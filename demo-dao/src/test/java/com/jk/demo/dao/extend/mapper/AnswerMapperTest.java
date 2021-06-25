package com.jk.demo.dao.extend.mapper;

import com.jk.demo.BaseMapperTest;
import com.jk.demo.dao.extend.entity.AnswerDao;
import com.jk.demo.dao.payload.AnswerPayload;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnswerMapperTest extends BaseMapperTest {
  @Resource AnswerMapper answerMapper;

  @Test
  void indexByNullTest() {
    List<AnswerDao> res = this.answerMapper.index(null);
    this.printRes(res);
    Assertions.assertNotNull(res);
  }

  @Test
  void indexByDegreeTest() {
    AnswerPayload payload = AnswerPayload.builder().degreeLow(60).degreeUp(100).build();
    System.out.println(payload);
    List<AnswerDao> res = this.answerMapper.index(payload);
    this.printRes(res);
    Assertions.assertNotNull(res);
  }

  @Test
  void indexByLetterGradeTest() {
    List<String> letterGrade = new ArrayList<>();
    letterGrade.add("A");
    letterGrade.add("D");
    AnswerPayload payload = AnswerPayload.builder().letterGrade(letterGrade).build();
    List<AnswerDao> res = this.answerMapper.index(payload);
    this.printRes(res);
    Assertions.assertNotNull(res);
  }

  @Test
  void indexBySNameTest() {
    AnswerPayload payload = AnswerPayload.builder().sName("曾").build();

    List<AnswerDao> res = this.answerMapper.index(payload);
    this.printRes(res);
    Assertions.assertNotNull(res);
  }

  @Test
  @SneakyThrows
  void indexBySBirthdayTest() {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    AnswerPayload payload =
        AnswerPayload.builder()
            .startStuDate(df.parse("1974-01-01"))
            .endStuDate(df.parse("1976-01-01"))
            .build();

    System.out.println(payload);

    List<AnswerDao> res = this.answerMapper.index(payload);
    this.printRes(res);
    Assertions.assertNotNull(res);
  }

  @Test
  void indexByPageTest() {
    AnswerPayload payload = AnswerPayload.builder().page(2).pageSize(2).build();
    payload.buildRowBounds();
    List<AnswerDao> res = this.answerMapper.index(payload);
    this.printRes(res);
    Assertions.assertNotNull(res);
  }

  @Test
  void indexBySortTest() {
    AnswerPayload payload =
        AnswerPayload.builder().sortColumnName("degree").sortDirection("desc").build();
    List<AnswerDao> res = this.answerMapper.index(payload);
    this.printRes(res);
    Assertions.assertNotNull(res);
  }

  void printRes(List<AnswerDao> res) {
    res.forEach(System.out::println);
  }
}
