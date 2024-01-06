package com.example.xblog.service;


import com.example.xblog.domain.Blog;
import com.example.xblog.domain.BlogExample;
import com.example.xblog.domain.Category;
import com.example.xblog.domain.CategoryExample;
import com.example.xblog.mapper.BlogMapper;
import com.example.xblog.mapper.CategoryMapper;
import com.example.xblog.req.BlogReq;
import com.example.xblog.req.CategoryReq;
import com.example.xblog.resp.BlogResp;
import com.example.xblog.resp.CategoryResp;
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
public class CategoryService {
    //打印日志
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(CategoryService.class);
    @Resource
    public CategoryMapper categoryMapper;
    @Resource
    private SnowFlake snowFlake;

    public PageResp<CategoryResp> list(CategoryReq req) {
        //固定写法
        CategoryExample example = new CategoryExample();
        //固定写法
        CategoryExample.Criteria criteria = example.createCriteria();
        //条件查询
        //分页(获取从页面传来的数据)
        PageHelper.startPage(req.getPage(), req.getSize());
        //定义分页
        PageResp<CategoryResp> pageResp = new PageResp<>();
        //类接收返回的数据
        List<Category> categoryList = categoryMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<CategoryResp> data = CopyUtil.copyList(categoryList, CategoryResp.class);
        //定义分页获取总数
        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        //将分页的数据进行总和
        pageResp.setTotal(pageInfo.getTotal());
        //将分页的数据加入类
        pageResp.setList(data);
        return pageResp;
    }
}
