package com.jk.demo.server.impl;

import com.jk.demo.dao.entity.User;
import com.jk.demo.dao.extend.mapper.UserExtendMapper;
import com.jk.demo.dao.mapper.UserMapper;
import com.jk.demo.payload.PasswordPayload;
import com.jk.demo.server.UserServiceInterface;
import com.jk.demo.utils.PwdUtils;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserServiceInterface {
  @Resource UserMapper userMapper;
  @Resource UserExtendMapper userExtendMapper;

  @Override
  public List<User> index() {
    return this.userMapper.selectAll();
  }

  @Override
  @Transactional
  public int changePassword(PasswordPayload payload) {
    User user = this.userExtendMapper.queryByUsername(payload.getUsername());
    if (payload.isValid(user.getPassword())) {
      user.withPassword(PwdUtils.encryption(payload.getNewPassword()))
          .withUpdatedAt(LocalDateTime.now());
      this.userMapper.updateByPrimaryKey(user);
    }
    return user.getId();
  }

  @Override
  @Transactional
  public User create(User user) {
    user.withCreatedAt(LocalDateTime.now()).withUpdatedAt(LocalDateTime.now());
    this.userMapper.insert(user);
    return user;
  }

  @Override
  @Transactional
  public int delete(String username) {
    return this.userExtendMapper.deleteByUsername(username);
  }

  @Override
  @Transactional
  public User update(User user) {
    user.withUpdatedAt(LocalDateTime.now());
    this.userExtendMapper.updateByPrimaryKey(user);
    return user;
  }

  @Override
  @Transactional
  public User queryById(Integer id) {
    return this.userMapper.selectByPrimaryKey(id);
  }

  @Override
  @Transactional
  public User queryByUsername(String username) {
    return this.userExtendMapper.queryByUsername(username);
  }
}
