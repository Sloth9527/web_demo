package com.jk.demo.dao.mapper;

import com.jk.demo.dao.entity.Grade;
import java.util.List;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Grade record);

    Grade selectByPrimaryKey(Integer id);

    List<Grade> selectAll();

    int updateByPrimaryKey(Grade record);
}