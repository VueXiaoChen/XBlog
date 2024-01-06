package com.example.xblog.mapper;

import com.example.xblog.domain.Likes;
import com.example.xblog.domain.LikesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LikesMapper {
    long countByExample(LikesExample example);

    int deleteByExample(LikesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Likes row);

    int insertSelective(Likes row);

    List<Likes> selectByExample(LikesExample example);

    Likes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Likes row, @Param("example") LikesExample example);

    int updateByExample(@Param("row") Likes row, @Param("example") LikesExample example);

    int updateByPrimaryKeySelective(Likes row);

    int updateByPrimaryKey(Likes row);
}