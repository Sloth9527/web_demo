package com.jk.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisServer implements RedisServerInterface {
  @Autowired private RedisTemplate redisTemplate;

  @Override
  public void setMsg(String key, String msg) {
    ValueOperations opsForValue = this.redisTemplate.opsForValue();
    opsForValue.set(key, msg);
  }

  @Override
  public String getMsg(String key) {
    return (String) this.redisTemplate.opsForValue().get(key);
  }

  @Override
  public void hPut(String key, String filed, Object obj) {
    HashOperations opsForHash = this.redisTemplate.opsForHash();
    opsForHash.put(key, filed, obj);
  }

  @Override
  public Object hGet(String key, String filed) {
    HashOperations opsForHash = this.redisTemplate.opsForHash();
    return opsForHash.get(key, filed);
  }
}
