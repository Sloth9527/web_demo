package com.jk.demo.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jk.demo")
public class DemoTestApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoTestApplication.class, args);
  }
}
