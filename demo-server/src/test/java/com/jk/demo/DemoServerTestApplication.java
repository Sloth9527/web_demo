package com.jk.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jk.demo")
@MapperScan(basePackages = "com.jk.demo.dao")
public class DemoServerTestApplication {}
