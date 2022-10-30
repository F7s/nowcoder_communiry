package com.lzh.community.controller;

import com.lzh.community.entity.Comment;
import com.lzh.community.service.CommentService;
import com.lzh.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/add/{discussPostId}", method = RequestMethod.POST)
    public String addComment(@PathVariable("discussPostId") int discussPostId, Comment comment) {
        comment.setUserId(hostHolder.getUser().getId());
        comment.setStatus(0);
        comment.setCreateTime(new Date());

        commentService.addComment(comment);

        return "redirect:/discuss/detail/" + discussPostId;
    }

}
