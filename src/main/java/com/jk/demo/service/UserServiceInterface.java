package com.jk.demo.service;

import com.jk.demo.Utils.PwdUtils;
import com.jk.demo.dao.entity.User;
import com.jk.demo.service.payload.PasswordPayload;
import com.jk.demo.service.payload.SignUpPayload;
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
