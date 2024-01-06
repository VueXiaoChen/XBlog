package com.example.xblog.service;


import com.example.xblog.domain.Category;
import com.example.xblog.domain.CategoryExample;
import com.example.xblog.domain.Likes;
import com.example.xblog.domain.LikesExample;
import com.example.xblog.mapper.CategoryMapper;
import com.example.xblog.mapper.LikesMapper;
import com.example.xblog.req.CategoryReq;
import com.example.xblog.req.LikesReq;
import com.example.xblog.resp.CategoryResp;
import com.example.xblog.resp.LikesResp;
import com.example.xblog.resp.PageResp;
import com.example.xblog.util.CopyUtil;
import com.example.xblog.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class LikesService {
    //打印日志
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(LikesService.class);
    @Resource
    public LikesMapper likesMapper;
    @Resource
    private SnowFlake snowFlake;

    public List<LikesResp> find(LikesReq req) {
        //固定写法
        LikesExample example = new LikesExample();
        //固定写法
        LikesExample.Criteria criteria = example.createCriteria();
        //条件查询
        if (!ObjectUtils.isEmpty(req.getUserId())) {
            criteria.andUserIdEqualTo(req.getUserId());
        }
        if (!ObjectUtils.isEmpty(req.getBlogId())) {
            criteria.andBlogIdEqualTo(req.getBlogId());
        }
        //类接收返回的数据
        List<Likes> likesList = likesMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<LikesResp> data = CopyUtil.copyList(likesList, LikesResp.class);
        return data;
    }
}
