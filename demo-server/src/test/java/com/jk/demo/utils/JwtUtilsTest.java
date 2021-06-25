package com.jk.demo.utils;

import com.jk.demo.BaseServerTest;
import com.jk.demo.dao.entity.User;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class JwtUtilsTest extends BaseServerTest {
  private User user1;
  private User user2;

  @BeforeEach
  void init() {
    this.initUser();
  }

  void initUser() {
    this.user1 = this.createUser("u1", "p1");
    this.user2 = this.createUser("u2", "p1");
  }

  User createUser(String name, String password) {
    User u =
        new User()
            .withUsername(name)
            .withNickname(name)
            .withPassword(PwdUtils.encryption(password))
            .withCreatedAt(LocalDateTime.now())
            .withUpdatedAt(LocalDateTime.now());

    return u;
  }

  @Test
  void sign() {
    String token = JwtUtils.sign(this.user1);
    log.info("token: {}", token);
    Map<String, String> map = new ConcurrentHashMap<>();
    Assertions.assertNotNull(token);
  }

  @Test
  void verify() {
    String t = JwtUtils.sign(this.user1);
    Boolean isVerify = JwtUtils.verify(t, this.user1);
    Assertions.assertTrue(isVerify);
  }

  @Test
  void getUsername() {
    String t = JwtUtils.sign(this.user1);
    String username = JwtUtils.getUsername(t);
    Assertions.assertEquals(username, this.user1.getUsername());
  }

  @Test
  void isTokenExpired() {
    String t = JwtUtils.sign(this.user1);
    Boolean isExpired = JwtUtils.isTokenExpired(t);
    Assertions.assertFalse(isExpired);
  }
}
