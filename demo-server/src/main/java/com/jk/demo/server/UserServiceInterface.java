package com.jk.demo.server;

import com.jk.demo.dao.entity.User;
import com.jk.demo.payload.PasswordPayload;
import com.jk.demo.payload.SignUpPayload;
import com.jk.demo.utils.PwdUtils;
import java.time.LocalDateTime;
import java.util.List;

public interface UserServiceInterface {
  List<User> index();

  int changePassword(PasswordPayload payload);

  User create(User user);

  int delete(String username);

  User update(User user);

  User queryById(Integer id);

  User queryByUsername(String username);

  static User buildUserByPayload(SignUpPayload payload) {
    User user =
        new User()
            .withUsername(payload.getUsername())
            .withNickname(payload.getNickname())
            .withPassword(PwdUtils.encryption(payload.getPassword()))
            .withCreatedAt(LocalDateTime.now())
            .withUpdatedAt(LocalDateTime.now());

    return user;
  }
}
