package com.example.xblog.controller;


import com.example.xblog.req.CategoryReq;
import com.example.xblog.req.UserLoadingReq;
import com.example.xblog.req.UserReq;
import com.example.xblog.resp.*;
import com.example.xblog.service.CategoryService;
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
@RequestMapping("/category")
public class CategoryController {
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(CategoryController.class);
    @Resource
    private CategoryService categoryService;
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private SnowFlake snowFlake;

    @Resource
    public RedisUtil redisUtil;

    @GetMapping("/list")
    //@Valid  开启参数检验
    public CommonResp list(@Valid CategoryReq req) {
        //返回信息里面定义返回的类型
        CommonResp<PageResp<CategoryResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        PageResp<CategoryResp> data = categoryService.list(req);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }
}
