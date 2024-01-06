package com.example.xblog.controller;


import com.example.xblog.resp.PageResp;
import com.example.xblog.req.UserReq;
import com.example.xblog.resp.CommonResp;
import com.example.xblog.req.UserLoadingReq;
import com.example.xblog.resp.UserLoadingResp;
import com.example.xblog.resp.UserResp;
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
@RequestMapping("/user")
public class UserController {
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private SnowFlake snowFlake;

    @Resource
    public RedisUtil redisUtil;

    @GetMapping("/list")
    //@Valid  开启参数检验
    public CommonResp list(@Valid UserReq req) {
        //返回信息里面定义返回的类型
        CommonResp<PageResp<UserResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        PageResp<UserResp> data = userService.list(req);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }
    @PostMapping("/loading")
    //@RequestBody  定义传过来的参数是实体类
    public CommonResp loading(@RequestBody UserLoadingReq userLoadingReq) {
        //返回信息里面定义返回的类型
        CommonResp<UserLoadingResp> resp = new CommonResp<>();
        //保存数据
        UserLoadingResp userLoadingResp = userService.loading(userLoadingReq);
        //雪花算法生成token
        Long token = snowFlake.nextId();
        //redisTemplate.opsForValue().set(token.toString(),userLoadingResp,3600*24*30, TimeUnit.SECONDS);
        //储存信息
        resp.setMessage("登录成功");
        resp.setData(userLoadingResp);
        return resp;
    }
}
