package com.jk.demo.dao.extend.mapper;

import com.jk.demo.dao.entity.User;

public interface UserExtendMapper {
  int deleteByUsername(String username);

  User queryByUsername(String username);

  int updateByPrimaryKey(User user);
}
