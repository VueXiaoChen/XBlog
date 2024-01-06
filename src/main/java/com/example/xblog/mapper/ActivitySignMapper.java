package com.example.xblog.mapper;

import com.example.xblog.domain.ActivitySign;
import com.example.xblog.domain.ActivitySignExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ActivitySignMapper {
    long countByExample(ActivitySignExample example);

    int deleteByExample(ActivitySignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivitySign row);

    int insertSelective(ActivitySign row);

    List<ActivitySign> selectByExample(ActivitySignExample example);

    ActivitySign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") ActivitySign row, @Param("example") ActivitySignExample example);

    int updateByExample(@Param("row") ActivitySign row, @Param("example") ActivitySignExample example);

    int updateByPrimaryKeySelective(ActivitySign row);

    int updateByPrimaryKey(ActivitySign row);
}