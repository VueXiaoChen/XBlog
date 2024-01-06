package com.example.xblog.service;


import com.example.xblog.domain.User;
import com.example.xblog.domain.UserExample;
import com.example.xblog.exception.BusinessException;
import com.example.xblog.exception.BusinessExceptionCode;
import com.example.xblog.mapper.UserMapper;
import com.example.xblog.resp.PageResp;
import com.example.xblog.req.UserLoadingReq;
import com.example.xblog.req.UserReq;
import com.example.xblog.resp.UserLoadingResp;
import com.example.xblog.resp.UserResp;
import com.example.xblog.util.CopyUtil;
import com.example.xblog.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserService {
    //打印日志
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserService.class);
    @Resource
    public UserMapper userMapper;
    @Resource
    private SnowFlake snowFlake;

    public PageResp<UserResp> list(UserReq req) {
        //固定写法
        UserExample example = new UserExample();
        //固定写法
        UserExample.Criteria criteria = example.createCriteria();
        //条件查询
        if (!ObjectUtils.isEmpty(req.getUsername())) {
            criteria.andUsernameLike("%" + req.getUsername() + "%");
        }
        if (!ObjectUtils.isEmpty(req.getEmail())) {
            criteria.andEmailLike("%" + req.getEmail() + "%");
        }
        if (!ObjectUtils.isEmpty(req.getPhone())) {
            criteria.andPhoneLike("%" + req.getPhone() + "%");
        }
        //分页(获取从页面传来的数据)
        PageHelper.startPage(req.getPage(), req.getSize());
        //定义分页
        PageResp<UserResp> pageResp = new PageResp<>();
        //类接收返回的数据
        List<User> userList = userMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<UserResp> data = CopyUtil.copyList(userList, UserResp.class);
        //定义分页获取总数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        //将分页的数据进行总和
        pageResp.setTotal(pageInfo.getTotal());
        //将分页的数据加入类
        pageResp.setList(data);
        return pageResp;
    }


    //查询是否有相同的用户名
    public User selectByLoginName(String LoadingName){
        //固定写法
        UserExample example = new UserExample();
        //固定写法
        UserExample.Criteria criteria = example.createCriteria();
        //查询用户名
        criteria.andUsernameEqualTo(LoadingName);
        //返回查询的实体类
        List<User> userList = userMapper.selectByExample(example);
        //判断是否有数据
        if(CollectionUtils.isEmpty(userList)){
            return null;
        }else{
            return userList.get(0);
        }
    }
    public UserLoadingResp loading(UserLoadingReq userLoadingReq) {
        User user = selectByLoginName(userLoadingReq.getUsername());
        if(ObjectUtils.isEmpty(user)){
            //判断用户名是否一样
            throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
        }else{
            if(user.getPassword().equals(userLoadingReq.getPassword())){
                //登录成功
                UserLoadingResp userLoadingResp = CopyUtil.copy(user,UserLoadingResp.class);
                LOG.info("登录成功");
                return userLoadingResp;
            }else{
                //账号或者密码错误
                throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
            }
        }
    }
}
