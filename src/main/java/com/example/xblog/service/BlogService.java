package com.example.xblog.service;


import com.example.xblog.domain.Blog;
import com.example.xblog.domain.BlogExample;
import com.example.xblog.domain.User;
import com.example.xblog.domain.UserExample;
import com.example.xblog.exception.BusinessException;
import com.example.xblog.exception.BusinessExceptionCode;
import com.example.xblog.mapper.BlogMapper;
import com.example.xblog.req.BlogReq;
import com.example.xblog.req.UserLoadingReq;
import com.example.xblog.resp.BlogResp;
import com.example.xblog.resp.PageResp;
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
public class BlogService {
    //打印日志
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(BlogService.class);
    @Resource
    public BlogMapper blogMapper;
    @Resource
    private SnowFlake snowFlake;

    public PageResp<BlogResp> list(BlogReq req) {
        //固定写法
        BlogExample example = new BlogExample();
        //需要的数据进行排序
        example.setOrderByClause("`date` desc");
        //固定写法
        BlogExample.Criteria criteria = example.createCriteria();
        //条件查询
        if (!ObjectUtils.isEmpty(req.getUserId())) {
            criteria.andUserIdEqualTo(req.getUserId());
        }
        if (!ObjectUtils.isEmpty(req.getId())) {
            criteria.andIdEqualTo(req.getId());
        }
        if (!ObjectUtils.isEmpty(req.getCategoryId())) {
            criteria.andCategoryIdEqualTo(req.getCategoryId());
        }
        if (!ObjectUtils.isEmpty(req.getId())) {
            criteria.andIdEqualTo(req.getId());
        }
        //时间排序然后热度排序
        //分页(获取从页面传来的数据)
        PageHelper.startPage(req.getPage(), req.getSize());
        //定义分页
        PageResp<BlogResp> pageResp = new PageResp<>();
        //类接收返回的数据
        List<Blog> blogList = blogMapper.selectByExampleWithBLOBs(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<BlogResp> data = CopyUtil.copyList(blogList, BlogResp.class);
        //定义分页获取总数
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        //将分页的数据进行总和
        pageResp.setTotal(pageInfo.getTotal());
        //将分页的数据加入类
        pageResp.setList(data);
        return pageResp;
    }

    public PageResp<BlogResp> readcountlist(BlogReq req) {
        //固定写法
        BlogExample example = new BlogExample();
        //需要的数据进行排序
        example.setOrderByClause("read_Count desc");
        //固定写法
        BlogExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(req.getReadCount())) {
            criteria.andReadCountGreaterThanOrEqualTo(req.getReadCount());
        }
        //分页(获取从页面传来的数据)
        PageHelper.startPage(req.getPage(), req.getSize());
        //定义分页
        PageResp<BlogResp> pageResp = new PageResp<>();
        //类接收返回的数据
        List<Blog> blogList = blogMapper.selectByExampleWithBLOBs(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<BlogResp> data = CopyUtil.copyList(blogList, BlogResp.class);
        //定义分页获取总数
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        //将分页的数据进行总和
        pageResp.setTotal(pageInfo.getTotal());
        //将分页的数据加入类
        pageResp.setList(data);
        return pageResp;
    }
}
