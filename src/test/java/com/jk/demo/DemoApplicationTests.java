package com.jk.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan(basePackages = {"com.jk.demo.dao.mapper", "com.jk.demo.dao.extend.mapper"})
class DemoApplicationTests {
  public static void main(String[] args) {
    SpringApplication.run(DemoApplicationTests.class, args);
  }
}
