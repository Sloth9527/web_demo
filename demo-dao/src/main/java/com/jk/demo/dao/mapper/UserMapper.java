package com.jk.demo.dao.mapper;

import com.jk.demo.dao.entity.User;
import java.util.List;

public interface UserMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(User record);

  User selectByPrimaryKey(Integer id);

  List<User> selectAll();

  int updateByPrimaryKey(User record);
}
