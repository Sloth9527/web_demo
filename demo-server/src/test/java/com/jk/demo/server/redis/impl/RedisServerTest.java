package com.jk.demo.server.redis.impl;

import com.jk.demo.BaseServerTest;
import com.jk.demo.server.redis.RedisServerInterface;
import com.jk.demo.utils.CloseUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.ScanOptions.ScanOptionsBuilder;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

@Slf4j
class RedisServerTest extends BaseServerTest {
  @Autowired private RedisServerInterface redisServerImpl;
  @Autowired private RedisTemplate<String, String> redisTemplate;

  private List<Integer> n;
  private Map<String, List<Integer>> h;

  @BeforeEach
  void init() {
    this.n = new ArrayList<>();
    this.n.add(1);
    this.n.add(2);
    this.n.add(3);

    this.h = new HashMap<>();
    this.h.put("l", this.n);
  }

  @Test
  void getMsg() {
    String key = "val";
    String value = "mongodb";
    this.redisServerImpl.setMsg(key, value);
    String val = this.redisServerImpl.getMsg(key);
    log.info("{}: {}", key, val);
    Assertions.assertEquals(value, val);
  }

  @Test
  void getAry() {
    String key = "op";
    String fileList = "array";
    String fileHash = "hash";

    this.redisServerImpl.hPut(key, fileList, this.n);
    this.redisServerImpl.hPut(key, fileHash, this.h);

    List<Integer> a = (List<Integer>) this.redisServerImpl.hGet(key, fileList);
    HashMap<String, List<Integer>> b =
        (HashMap<String, List<Integer>>) this.redisServerImpl.hGet(key, fileHash);
    log.info("List: {}", a);
    log.info("Hash: {}", b);
    Assertions.assertEquals(this.h, b);
    Assertions.assertEquals(this.n, a);
  }

  @Test
  void StringTest() {
    ValueOperations<String, String> valueOperations = this.redisTemplate.opsForValue();

    String key = "key_value";
    valueOperations.set(key, "ttt");
    log.info("{}: {}", key, valueOperations.get(key));

    Map<String, String> hashMap = new HashMap<>();
    hashMap.put(key, "ttt2");
    valueOperations.multiSet(hashMap);
    log.info("{}: {}", key, valueOperations.get(key));

    // 如果不存在赋值
    valueOperations.setIfAbsent(key, "absent");
    log.info("{}: {}", key, valueOperations.get(key));

    // 入国存在赋值
    valueOperations.setIfPresent(key, "present");
    log.info("{}: {}", key, valueOperations.get(key));

    String keyIncrement = "increment";
    valueOperations.increment(keyIncrement);
    valueOperations.increment(keyIncrement);
    log.info("{}: {}", keyIncrement, valueOperations.get(keyIncrement));
    valueOperations.decrement(keyIncrement);
    log.info("{}: {}", keyIncrement, valueOperations.get(keyIncrement));

    List<String> keys = new ArrayList<>();
    keys.add(key);
    keys.add(keyIncrement);
    log.info("{}: {}", keys, valueOperations.multiGet(keys));
  }

  @Test
  void listTest() {
    ListOperations<String, String> opsList = this.redisTemplate.opsForList();
    List<String> ll = new ArrayList<>();
    ll.add("9");
    ll.add("20");
    ll.add("33");
    ll.add("89");
    ll.add("1");

    String key = "lll";
    this.redisTemplate.delete(key);

    opsList.leftPushIfPresent(key, "left_present");
    opsList.rightPushIfPresent(key, "right_present");
    log.info("{} : {}", key, opsList.range(key, 0, -1));

    opsList.leftPush(key, "mid");
    log.info("{} : {}", key, opsList.range(key, 0, -1));
    opsList.leftPushAll(key, ll);
    opsList.rightPushAll(key, ll);
    log.info("{} : {}", key, opsList.range(key, 0, -1));

    log.info("{} indexOf mid: {}", key, opsList.indexOf(key, "mid"));

    opsList.leftPush(key, "left");
    opsList.rightPush(key, "right");
    log.info("{} : {}", key, opsList.range(key, 0, -1));

    log.info("{} size: {}", key, opsList.size(key));

    // count 删除所匹配的数量
    opsList.remove(key, 2, "33");
    log.info("{} : {}", key, opsList.range(key, 0, -1));

    opsList.leftPush(key, "mid", "mid_left");
    log.info("{} : {}", key, opsList.range(key, 0, -1));

    opsList.rightPush(key, "mid", "mid_right");
    log.info("{} : {}", key, opsList.range(key, 0, -1));

    opsList.set(key, 2, "index_2");
    log.info("{} : {}", key, opsList.range(key, 0, -1));

    opsList.trim(key, 2, 3);
    log.info("{} trim 2 3: {}", key, opsList.range(key, 0, -1));
  }

  @Test
  void setTest() {
    SetOperations<String, String> setOperations = this.redisTemplate.opsForSet();
    String key = "k_set";

    String keyOther = "k_other_set";

    setOperations.add(key, "123");
    setOperations.add(key, "redis");
    log.info("{} members: {}", key, setOperations.members(key));
    log.info("{} members: {}", keyOther, setOperations.members(keyOther));

    setOperations.add(keyOther, "123");
    setOperations.add(keyOther, "222");
    setOperations.add(keyOther, "fff");

    log.info("{} different {}: {}", key, keyOther, setOperations.difference(key, keyOther));
    log.info("{} different {}: {}", keyOther, key, setOperations.difference(keyOther, key));
    log.info("{} union {}: {}", key, keyOther, setOperations.union(key, keyOther));

    setOperations.move(key, "redis", keyOther);
    log.info("{} members: {}", key, setOperations.members(key));
    log.info("{} members: {}", keyOther, setOperations.members(keyOther));

    log.info("{} isMember: {}", key, setOperations.isMember(key, "redis"));
    log.info("{} isMember: {}", keyOther, setOperations.isMember(keyOther, "redis"));

    log.info("{} size: {}", keyOther, setOperations.size(keyOther));

    log.info("{} randomMember: {}", keyOther, setOperations.randomMember(keyOther));
    log.info("{} members: {}", keyOther, setOperations.members(keyOther));

    log.info("{} pop: {}", keyOther, setOperations.pop(keyOther));
    log.info("{} members: {}", keyOther, setOperations.members(keyOther));

    ScanOptions scanOptions = new ScanOptionsBuilder().match("*2*").count(100).build();
    Cursor<String> cursor = setOperations.scan(keyOther, scanOptions);

    try {
      while (cursor.hasNext()) {
        log.info("cursor: {}", cursor.next());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      CloseUtils.close(cursor);
    }
  }

  @Test
  void hashTest() {
    HashOperations<String, String, String> hashOperations = this.redisTemplate.opsForHash();

    String hashKey = "op";
    String opKey1 = "list";
    String opKey2 = "filed_key";

    hashOperations.put(hashKey, opKey1, "list_string");
    log.info("{}.{}: {}", hashKey, opKey1, hashOperations.get(hashKey, opKey1));

    Map<String, String> map = new HashMap<>();
    map.put(opKey1, "op1");
    map.put(opKey2, "op2");
    hashOperations.putAll(hashKey, map);
    log.info("{}.{}: {}", hashKey, opKey1, hashOperations.get(hashKey, opKey1));
    log.info("{}.{}: {}", hashKey, opKey2, hashOperations.get(hashKey, opKey2));

    log.info("{} entries: {}", hashKey, hashOperations.entries(hashKey));

    List<String> keys = new ArrayList<>();
    keys.add(opKey1);
    keys.add(opKey2);
    keys.add("array");
    log.info("{} {}: {}", hashKey, keys, hashOperations.multiGet(hashKey, keys));

    log.info("{} values: {}", hashKey, hashOperations.values(hashKey));
  }

  @Test
  void zSetTest() {
    ZSetOperations<String, String> zSetOperations = this.redisTemplate.opsForZSet();

    String zKey = "z_set";
    zSetOperations.add(zKey, "a", 9);
    zSetOperations.add(zKey, "aZ", 100);
    zSetOperations.add(zKey, "p", 5);
    log.info("{} : {}", zKey, zSetOperations.range(zKey, 0, -1));

    log.info("{} reverseRange 0 0: {}", zKey, zSetOperations.reverseRange(zKey, 0, 0));
    log.info("{} reverseRange 0 1: {}", zKey, zSetOperations.reverseRange(zKey, 0, 1));
    log.info("{} reverseRange 0 2: {}", zKey, zSetOperations.reverseRange(zKey, 0, 2));

    log.info("{} count 0 99: {}", zKey, zSetOperations.count(zKey, 0, 99));

    zSetOperations.remove(zKey, "a");
    log.info("{} : {}", zKey, zSetOperations.range(zKey, 0, -1));
  }
}
