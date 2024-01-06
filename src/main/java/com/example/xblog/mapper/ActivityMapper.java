package com.example.xblog.mapper;

import com.example.xblog.domain.Activity;
import com.example.xblog.domain.ActivityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ActivityMapper {
    long countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Activity row);

    int insertSelective(Activity row);

    List<Activity> selectByExampleWithBLOBs(ActivityExample example);

    List<Activity> selectByExample(ActivityExample example);

    Activity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Activity row, @Param("example") ActivityExample example);

    int updateByExampleWithBLOBs(@Param("row") Activity row, @Param("example") ActivityExample example);

    int updateByExample(@Param("row") Activity row, @Param("example") ActivityExample example);

    int updateByPrimaryKeySelective(Activity row);

    int updateByPrimaryKeyWithBLOBs(Activity row);

    int updateByPrimaryKey(Activity row);
}