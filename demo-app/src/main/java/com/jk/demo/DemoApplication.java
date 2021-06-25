package com.jk.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jk.demo")
@MapperScan(basePackages = "com.jk.demo.dao")
// @EnableAdminServer
public class DemoApplication {
  public static void main(final String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}
