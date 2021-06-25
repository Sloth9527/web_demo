package com.jk.demo.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
  public static final String Q_EMAIL = "q_email";
  public static final String Q_SMS = "q_sms";
  public static final String Q_APP = "q_app";
  public static final String LOGIN_EXCHANGE = "login";
  public static final String REGISTRATION_EXCHANGE = "registration";
  public static final String LOGIN_FAILED_ROUTER = "login_failed";

  @Bean(name = Q_EMAIL)
  public Queue emailQueue() {
    return new Queue(Q_EMAIL, true, false, false, null);
  }

  @Bean(name = Q_SMS)
  public Queue smsQueue() {
    return new Queue(Q_SMS, true, false, false, null);
  }

  @Bean(name = Q_APP)
  public Queue appQueue() {
    return new Queue(Q_APP, true, false, false, null);
  }

  @Bean(name = LOGIN_EXCHANGE)
  public DirectExchange loginExchange() {
    return new DirectExchange(LOGIN_EXCHANGE);
  }

  @Bean(name = REGISTRATION_EXCHANGE)
  public DirectExchange registrationExchange() {
    return new DirectExchange(REGISTRATION_EXCHANGE);
  }

  @Bean
  public Binding registrationToEmailBinding(
      @Qualifier(Q_EMAIL) Queue queue, @Qualifier(REGISTRATION_EXCHANGE) DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(REGISTRATION_EXCHANGE);
  }

  @Bean
  public Binding registrationToSmsBinding(
      @Qualifier(Q_SMS) Queue queue, @Qualifier(REGISTRATION_EXCHANGE) DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(REGISTRATION_EXCHANGE);
  }

  @Bean
  public Binding LoginToEmailBinding(
      @Qualifier(Q_EMAIL) Queue queue, @Qualifier(LOGIN_EXCHANGE) DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(LOGIN_FAILED_ROUTER);
  }

  @Bean
  public Binding LoginToSmsBinding(
      @Qualifier(Q_SMS) Queue queue, @Qualifier(LOGIN_EXCHANGE) DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(LOGIN_EXCHANGE);
  }

  @Bean
  public Binding LoginToAppBinding(
      @Qualifier(Q_APP) Queue queue, @Qualifier(LOGIN_EXCHANGE) DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(LOGIN_EXCHANGE);
  }
}
