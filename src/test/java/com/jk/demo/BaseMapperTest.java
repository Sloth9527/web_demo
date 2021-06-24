package com.jk.demo;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
@Transactional
public class BaseMapperTest extends BaseApplicationTest {
  @Value("${spring.datasource.url}")
  private String url;

  @Value("${spring.datasource.username}")
  private String user;

  @Value("${spring.datasource.password}")
  private String password;

  @BeforeAll
  public void loadDB() {
    Flyway flyway = Flyway.configure().dataSource(this.url, this.user, this.password).load();
    flyway.clean();
    flyway.migrate();
    log.info("flyway cleaned and migrated.");
  }
}
