package com.jk.demo.controller;

import com.jk.demo.aspect.Authority;
import com.jk.demo.dao.entity.User;
import com.jk.demo.dao.extend.entity.UserDao;
import com.jk.demo.payload.UserPayload;
import com.jk.demo.response.Response;
import com.jk.demo.server.UserServiceInterface;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
  @Autowired private UserServiceInterface userServiceInterfaceImpl;

  @GetMapping("list")
  public Response<List<UserDao>> list() {
    List<User> list = this.userServiceInterfaceImpl.index();
    return Response.success(list.stream().map(UserDao::buildBy).collect(Collectors.toList()));
  }

  @GetMapping("/{userId}")
  public Response<UserDao> getUser(@PathVariable int userId) {
    User u = this.userServiceInterfaceImpl.queryById(userId);
    return Response.success(UserDao.buildBy(u));
  }

  @PatchMapping("/{userId}/update")
  @Authority
  public Response<UserDao> update(@PathVariable int userId, @RequestBody UserPayload payload) {
    User user = this.userServiceInterfaceImpl.queryById(userId);
    user.setNickname(payload.getNickname());
    user.setUsername(payload.getUsername());
    User res = this.userServiceInterfaceImpl.update(user);
    return Response.success(UserDao.buildBy(res));
  }
}
