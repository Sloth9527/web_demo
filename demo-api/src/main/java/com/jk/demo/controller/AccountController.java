package com.jk.demo.controller;

import com.jk.demo.configuration.RabbitMqConfig;
import com.jk.demo.dao.entity.User;
import com.jk.demo.dao.extend.entity.UserDao;
import com.jk.demo.payload.LoginPayload;
import com.jk.demo.payload.PasswordPayload;
import com.jk.demo.payload.SignUpPayload;
import com.jk.demo.response.Response;
import com.jk.demo.response.UnauthorizedResponse;
import com.jk.demo.server.UserServiceInterface;
import com.jk.demo.server.mq.Message;
import com.jk.demo.server.mq.MessagingServer;
import com.jk.demo.utils.JwtUtils;
import com.jk.demo.utils.PwdUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {
  @Autowired private UserServiceInterface userServiceInterfaceImpl;
  @Autowired MessagingServer messagingServer;

  @PostMapping("/login")
  public Response<String> login(@RequestBody LoginPayload payload) {
    User user = this.userServiceInterfaceImpl.queryByUsername(payload.getUsername());
    List<String> s = new ArrayList<>();
    Message message =
        Message.builder()
            .type(RabbitMqConfig.LOGIN_EXCHANGE)
            .message(payload.getUsername())
            .success(true)
            .build();
    if (!this.isValid(user, payload.getPassword())) {
      message.setSuccess(false);
      this.messagingServer.sendLoginMessage(message);
      return UnauthorizedResponse.failed("username or password is incorrect");
    }

    String token = JwtUtils.sign(user);

    this.messagingServer.sendLoginMessage(message);

    return Response.success(token);
  }

  @PostMapping("/create")
  public Response<UserDao> create(@RequestBody SignUpPayload signUpPayload) {
    User user =
        this.userServiceInterfaceImpl.create(
            UserServiceInterface.buildUserByPayload(signUpPayload));

    Message message =
        Message.builder()
            .message(user.getUsername())
            .type(RabbitMqConfig.REGISTRATION_EXCHANGE)
            .success(true)
            .build();
    this.messagingServer.sendRegistrationMessage(message);

    return Response.success(UserDao.buildBy(user));
  }

  @PostMapping("/destroy")
  public Response<Integer> destroy(@RequestBody LoginPayload payload) {
    User user = this.userServiceInterfaceImpl.queryByUsername(payload.getUsername());

    if (!this.isValid(user, payload.getPassword())) {
      return UnauthorizedResponse.failed();
    }

    int id = this.userServiceInterfaceImpl.delete(user.getUsername());

    return Response.success(id);
  }

  @PostMapping("/change_password")
  public Response<String> changePassword(@RequestBody PasswordPayload payload) {
    User user = this.userServiceInterfaceImpl.queryByUsername(payload.getUsername());

    if (!this.isValid(user, payload.getOldPassword())) {
      return UnauthorizedResponse.failed();
    }

    this.userServiceInterfaceImpl.changePassword(payload);

    return Response.success();
  }

  private Boolean isValid(User u, String pwd) {
    if (u == null) {
      return false;
    }
    return pwd != null
        && pwd.length() > 0
        && Objects.equals(PwdUtils.encryption(pwd), u.getPassword());
  }
}
