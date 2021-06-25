package com.jk.demo.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
@EnableAutoConfiguration
public class RedisConfig {

  @Bean
  Jackson2JsonRedisSerializer<Object> serializer() {
    Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer(Object.class);

    ObjectMapper objectMapper = new ObjectMapper();
    // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
    objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
    objectMapper.activateDefaultTyping(
        LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);

    serializer.setObjectMapper(objectMapper);
    return serializer;
  }

  @Bean
  GenericJackson2JsonRedisSerializer genericSerializer() {
    return new GenericJackson2JsonRedisSerializer();
  }

  @Bean
  GenericToStringSerializer genericToStringSerializer() {
    return new GenericToStringSerializer(String.class);
  }

  @Bean
  public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
    RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

    GenericToStringSerializer keySerializer = this.genericToStringSerializer();

    redisTemplate.setKeySerializer(keySerializer);
    redisTemplate.setHashKeySerializer(keySerializer);

    GenericJackson2JsonRedisSerializer valuesSerializer = this.genericSerializer();

    redisTemplate.setValueSerializer(valuesSerializer);
    redisTemplate.setHashValueSerializer(valuesSerializer);

    redisTemplate.setConnectionFactory(connectionFactory);

    return redisTemplate;
  }
}
