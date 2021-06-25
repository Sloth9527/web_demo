package com.jk.demo.configuration;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class RabbitMQConfiguration {
  @Bean
  MessageConverter createMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
