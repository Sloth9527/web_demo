package com.jk.demo.dao.mapper;

import com.jk.demo.dao.entity.Profile;
import java.util.List;

public interface ProfileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Profile record);

    Profile selectByPrimaryKey(Integer id);

    List<Profile> selectAll();

    int updateByPrimaryKey(Profile record);
}