package com.example.xblog.controller;


import com.example.xblog.req.BlogReq;
import com.example.xblog.req.UserLoadingReq;
import com.example.xblog.req.UserReq;
import com.example.xblog.resp.*;
import com.example.xblog.service.BlogService;
import com.example.xblog.service.UserService;
import com.example.xblog.util.RedisUtil;
import com.example.xblog.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


@RestController
@RequestMapping("/blog")
public class BlogController {
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(BlogController.class);
    @Resource
    private BlogService blogService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private SnowFlake snowFlake;

    @Resource
    public RedisUtil redisUtil;

    @GetMapping("/list")
    //@Valid  开启参数检验
    public CommonResp list(@Valid BlogReq req) {
        //返回信息里面定义返回的类型
        CommonResp<PageResp<BlogResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        PageResp<BlogResp> data = blogService.list(req);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }
    @GetMapping("/readcountlist")
    public CommonResp readcountlist(@Valid BlogReq req) {
        //返回信息里面定义返回的类型
        CommonResp<PageResp<BlogResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        PageResp<BlogResp> data = blogService.readcountlist(req);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }
}
