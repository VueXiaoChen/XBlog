package com.example.xblog.controller;


import com.example.xblog.req.CollectReq;
import com.example.xblog.req.LikesReq;
import com.example.xblog.resp.CollectResp;
import com.example.xblog.resp.CommonResp;
import com.example.xblog.resp.LikesResp;
import com.example.xblog.service.CollectService;
import com.example.xblog.service.LikesService;
import com.example.xblog.util.RedisUtil;
import com.example.xblog.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/collect")
public class CollectController {
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(CollectController.class);
    @Resource
    private CollectService collectService;
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private SnowFlake snowFlake;

    @Resource
    public RedisUtil redisUtil;

    @GetMapping("/find")
    //@Valid  开启参数检验
    public CommonResp find(@Valid CollectReq req) {
        //返回信息里面定义返回的类型
        CommonResp<List<CollectResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        List<CollectResp> data = collectService.find(req);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }
}
