package com.jk.demo.dao.mapper;

import com.jk.demo.BaseMapperTest;
import com.jk.demo.dao.entity.Student;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class StudentMapperTest extends BaseMapperTest {
  @Resource StudentMapper studentMapper;

  @Test
  void selectAll() {
    List<Student> students = this.studentMapper.selectAll();

    students.stream()
        .forEach(
            s -> {
              log.info(s.toString());
            });

    Assertions.assertNotNull(students);
  }
}
