package com.jk.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jk.demo")
public class TestDemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(TestDemoApplication.class, args);
  }
}
