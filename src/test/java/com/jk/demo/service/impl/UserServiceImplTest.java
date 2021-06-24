package com.jk.demo.service.impl;

import com.jk.demo.BaseServerTest;
import com.jk.demo.Utils.PwdUtils;
import com.jk.demo.dao.entity.User;
import com.jk.demo.service.UserServiceInterface;
import com.jk.demo.service.payload.PasswordPayload;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserServiceImplTest extends BaseServerTest {
  @Autowired UserServiceInterface userServiceImpl;

  private final String PASSWORD = "password";
  private final String USERNAME = "u1";

  private User user1 = null;

  public User buildUser(String username) {
    User u =
        new User()
            .withUsername(username)
            .withNickname(username)
            .withPassword(PwdUtils.encryption(this.PASSWORD))
            .withCreatedAt(LocalDateTime.now())
            .withUpdatedAt(LocalDateTime.now());

    return u;
  }

  public User createUser(String username) {
    User u = this.buildUser(username);
    this.userServiceImpl.create(u);
    return u;
  }

  @BeforeEach
  void intUser() {
    this.user1 = this.createUser(this.USERNAME);
  }

  @Test
  void index() {
    List<User> users = this.userServiceImpl.index();
    Assertions.assertEquals(1, users.size());
  }

  @Test
  void changePassword() {
    String newPassword = "123";
    String pwdHex = PwdUtils.encryption(newPassword);
    Integer uId = this.user1.getId();
    PasswordPayload payload =
        PasswordPayload.builder()
            .oldPassword(this.PASSWORD)
            .newPassword(newPassword)
            .repeatNewPassword(newPassword)
            .username(this.USERNAME)
            .build();
    this.userServiceImpl.changePassword(payload);

    User u = this.userServiceImpl.queryById(uId);
    Assertions.assertEquals(pwdHex, u.getPassword());
  }

  @Test
  void create() {
    String uName = "create";
    User u1 = this.buildUser(uName);
    User u = this.userServiceImpl.create(u1);
    User res = this.userServiceImpl.queryByUsername(uName);
    Assertions.assertEquals(u.getId(), res.getId());
  }

  @Test
  void delete() {
    this.userServiceImpl.delete(this.user1.getUsername());
    User u = this.userServiceImpl.queryById(this.user1.getId());
    Assertions.assertNull(u);
  }

  @Test
  void update() throws InterruptedException {
    String newName = "newName";
    User updateUer = this.buildUser(newName);
    updateUer.withCreatedAt(this.user1.getCreatedAt()).withUpdatedAt(LocalDateTime.now());
    updateUer.setId(this.user1.getId());
    this.userServiceImpl.update(updateUer);
    User res = this.userServiceImpl.queryByUsername(newName);
    Assertions.assertEquals(newName, res.getUsername());
    Assertions.assertEquals(newName, res.getNickname());
  }

  @Test
  void queryById() {
    User u = this.userServiceImpl.queryByUsername(this.USERNAME);
    Assertions.assertEquals(this.user1.getId(), u.getId());
  }

  @Test
  void queryByUsername() {
    User u = this.userServiceImpl.queryByUsername(this.USERNAME);
    Assertions.assertEquals(this.user1.getId(), u.getId());
  }
}
