package com.example.xblog.service;


import com.example.xblog.domain.Collect;
import com.example.xblog.domain.CollectExample;
import com.example.xblog.domain.Likes;
import com.example.xblog.domain.LikesExample;
import com.example.xblog.mapper.CollectMapper;
import com.example.xblog.mapper.LikesMapper;
import com.example.xblog.req.CollectReq;
import com.example.xblog.req.LikesReq;
import com.example.xblog.resp.CollectResp;
import com.example.xblog.resp.LikesResp;
import com.example.xblog.util.CopyUtil;
import com.example.xblog.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CollectService {
    //打印日志
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(CollectService.class);
    @Resource
    public CollectMapper collectMapper;
    @Resource
    private SnowFlake snowFlake;

    public List<CollectResp> find(CollectReq req) {
        //固定写法
        CollectExample example = new CollectExample();
        //固定写法
        CollectExample.Criteria criteria = example.createCriteria();
        //条件查询
        if (!ObjectUtils.isEmpty(req.getUserId())) {
            criteria.andUserIdEqualTo(req.getUserId());
        }
        if (!ObjectUtils.isEmpty(req.getBlogId())) {
            criteria.andBlogIdEqualTo(req.getBlogId());
        }
        //类接收返回的数据
        List<Collect> collectList = collectMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<CollectResp> data = CopyUtil.copyList(collectList, CollectResp.class);
        return data;
    }
}
