package com.jk.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@SpringBootTest(classes = TestDemoApplication.class)
@ExtendWith(SpringExtension.class)
public class BaseApplicationTest {}