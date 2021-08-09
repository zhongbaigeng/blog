package com.dreamchaser.controller;

import com.dreamchaser.pojo.Blog;
import com.dreamchaser.service.BlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Api(description = "博客管理")
@Controller
public class BlogCtroller {
    @Autowired
    BlogService blogService;


    @ApiOperation(value = "添加博客")
    @PostMapping(value = "/blog")
    public ModelAndView  insertBlog(Blog blog){
        ModelAndView mv=new ModelAndView();
        //配合查找
        blog.setTags(","+blog.getTags()+",");
        mv.setViewName("admin/tip");
        if (blogService.addBlog(blog)==1){
            mv.addObject("message","博客保存成功!");
        }else {
            mv.addObject("message","博客保存失败!");
        }
        return mv;
    }
    @ApiOperation(value = "删除博客")
    @DeleteMapping(value = "/blog")
    public ModelAndView  deleteBlog(@RequestParam Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (blogService.deleteBlog(id)==1){
            mv.addObject("message","博客删除成功!");
        }else {
            mv.addObject("message","博客删除失败!");
        }
        return mv;
    }
    @ApiOperation(value = "修改博客")
    @PutMapping(value = "/blog")
    public ModelAndView  update(Blog blog){
        blog.setTags(","+blog.getTags()+",");
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (blogService.updateBlog(blog)==1){
            mv.addObject("message","博客更新成功!");
        }else {
            mv.addObject("message","博客更新失败!");
        }
        return mv;
    }
}
