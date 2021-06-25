package com.jk.demo.dao.extend.mapper;

import com.jk.demo.dao.extend.entity.AnswerDao;
import com.jk.demo.dao.payload.AnswerPayload;
import java.util.List;

public interface AnswerMapper {
  List<AnswerDao> index(AnswerPayload payload);
}
