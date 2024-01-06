package com.example.xblog.mapper;

import com.example.xblog.domain.Notice;
import com.example.xblog.domain.NoticeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface NoticeMapper {
    long countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Notice row);

    int insertSelective(Notice row);

    List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Notice row, @Param("example") NoticeExample example);

    int updateByExample(@Param("row") Notice row, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice row);

    int updateByPrimaryKey(Notice row);
}