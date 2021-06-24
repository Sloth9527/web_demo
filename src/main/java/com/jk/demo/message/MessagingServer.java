package com.jk.demo.message;

import com.jk.demo.configuration.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagingServer {
  @Autowired RabbitTemplate rabbitTemplate;

  public void sendRegistrationMessage(Message message) {
    this.rabbitTemplate.convertAndSend(
        RabbitMqConfig.REGISTRATION_EXCHANGE, RabbitMqConfig.REGISTRATION_EXCHANGE, message);
  }

  public void sendLoginMessage(Message message) {
    String routingKey =
        message.getSuccess() ? RabbitMqConfig.LOGIN_EXCHANGE : RabbitMqConfig.LOGIN_FAILED_ROUTER;
    this.rabbitTemplate.convertAndSend(RabbitMqConfig.LOGIN_EXCHANGE, routingKey, message);
  }
}
