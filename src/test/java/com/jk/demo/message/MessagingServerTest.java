package com.jk.demo.message;

import com.jk.demo.BaseServerTest;
import com.jk.demo.configuration.RabbitMqConfig;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class MessagingServerTest extends BaseServerTest {
  @Autowired MessagingServer messagingServer;

  @Test
  void sendRegistrationMessage() {
    Message message =
        Message.builder()
            .type(RabbitMqConfig.REGISTRATION_EXCHANGE)
            .message("registration")
            .success(true)
            .build();
    this.messagingServer.sendRegistrationMessage(message);
  }

  @Test
  void sendLoginMessageBySuccess() {
    Message message =
        Message.builder()
            .type(RabbitMqConfig.LOGIN_EXCHANGE)
            .message("login")
            .success(true)
            .build();
    this.messagingServer.sendLoginMessage(message);
  }

  @Test
  @SneakyThrows
  void sendLoginMessageByFailed() {
    Message message =
        Message.builder()
            .type(RabbitMqConfig.LOGIN_EXCHANGE)
            .message("login")
            .success(false)
            .build();
    this.messagingServer.sendLoginMessage(message);
    message.setMessage("login2");
    this.messagingServer.sendLoginMessage(message);
    message.setMessage("login3");
    this.messagingServer.sendLoginMessage(message);
    message.setMessage("login4");
    this.messagingServer.sendLoginMessage(message);
  }
}
