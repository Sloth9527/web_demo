package com.jk.demo.dao.mapper;

import com.jk.demo.dao.entity.Score;
import java.util.List;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    Score selectByPrimaryKey(Integer id);

    List<Score> selectAll();

    int updateByPrimaryKey(Score record);
}