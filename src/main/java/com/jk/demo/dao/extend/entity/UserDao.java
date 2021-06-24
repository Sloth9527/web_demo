package com.jk.demo.dao.extend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jk.demo.dao.entity.User;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDao implements Serializable {
  private int id;
  private String username;
  private String nickname;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updatedAt;

  public static UserDao buildBy(User user) {
    return UserDao.builder()
        .id(user.getId())
        .username(user.getUsername())
        .nickname(user.getNickname())
        .createdAt(user.getCreatedAt())
        .updatedAt(user.getUpdatedAt())
        .build();
  }
}
