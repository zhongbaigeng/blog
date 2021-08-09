package com.dreamchaser.controller;

import com.dreamchaser.service.CommentCombinationService;
import com.dreamchaser.service.CommentService;
import com.dreamchaser.utils.MapUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author sun
 */
@Api(description = "评论组合管理")
@Controller
public class CommentCombinationController {
    @Autowired
    CommentCombinationService commentCombinationService;

    @ApiOperation(value = "查询评论")
    @GetMapping("/commentCombination")
    public String findCommentCombinationByPage(@RequestParam Map<String,Object> map, Model model){
        model.addAttribute("comments",commentCombinationService.findCommentByPage(MapUtil.handle(map)));
        return "admin/comments::table_refresh";
    }

}
