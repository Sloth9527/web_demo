package com.jk.demo.dao.extend.entity;

import com.jk.demo.dao.entity.Course;
import com.jk.demo.dao.entity.Student;
import com.jk.demo.dao.entity.Teacher;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDao implements Serializable {
  private Integer id;

  private String sNo;

  private String cNo;

  private BigDecimal degree;

  private String letterGrade;

  private Student student;
  private Course course;
  private Teacher teacher;
}
