package com.jk.demo.redis;

public interface RedisServerInterface {
  void setMsg(String key, String msg);

  String getMsg(String key);

  void hPut(String key, String filed, Object obj);

  Object hGet(String key, String filed);
}
