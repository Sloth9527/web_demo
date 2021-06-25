package com.jk.demo.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = DemoTestApplication.class)
@ExtendWith(SpringExtension.class)
public class BaseApplicationTest {}
