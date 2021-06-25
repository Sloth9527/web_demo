package com.jk.demo.server.mq.listioner;

import com.jk.demo.configuration.RabbitMqConfig;
import com.jk.demo.server.mq.Message;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueueMessageListener {
  private final Integer sleepTime = 1000 * 10;
  private final Integer expireTime = 1000 * 60 * 60 * 24 * 30;

  @RabbitListener(queues = RabbitMqConfig.Q_EMAIL)
  @SneakyThrows
  public void onLoginMessageFromMailQueue(Message message) {
    Thread.sleep(this.sleepTime);
    log.info("queue {} received message: {}", RabbitMqConfig.Q_EMAIL, message);
  }

  @RabbitListener(queues = RabbitMqConfig.Q_SMS)
  @SneakyThrows
  public void onLoginMessageFromSMSQueue(Message message) {
    Thread.sleep(this.sleepTime);
    log.info("queue {} received message: {}", RabbitMqConfig.Q_SMS, message);
  }

  @RabbitListener(queues = RabbitMqConfig.Q_APP)
  @SneakyThrows
  public void onLoginMessageFromAPPQueue(Message message) {
    Thread.sleep(this.sleepTime);
    log.info("queue {} received message: {}", RabbitMqConfig.Q_APP, message);
  }
}
