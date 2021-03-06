package com.jk.demo.dao.mapper;

import com.jk.demo.dao.entity.Teacher;
import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    List<Teacher> selectAll();

    int updateByPrimaryKey(Teacher record);
}