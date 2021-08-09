package com.dreamchaser.controller;

import com.dreamchaser.pojo.Comment;
import com.dreamchaser.service.BlogService;
import com.dreamchaser.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author sun
 */
@Api(description = "评论管理")
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    BlogService blogService;
    @ApiOperation(value = "添加评论")
    @PostMapping("/comment")
    public String insertComment(Comment comment, HttpSession session){
        if (session.getAttribute("user")==null){
            comment.setIsAdmin(0);
        }else {
            comment.setIsAdmin(1);
        }
        commentService.insertComment(comment);
        return "redirect:/page_blog/"+comment.getBlog();
    }

    @ApiOperation(value = "删除评论")
    @DeleteMapping("/comment")
    public ModelAndView deleteComment(Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (commentService.deleteCommentById(id)==1){
            mv.addObject("message","评论删除成功！");
        }else{
            mv.addObject("message","评论删除失败！");
        }
        return mv;
    }
}
