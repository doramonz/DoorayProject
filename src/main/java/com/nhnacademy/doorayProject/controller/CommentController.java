package com.nhnacademy.doorayProject.controller;

import com.nhnacademy.doorayProject.dto.CommentDto;
import com.nhnacademy.doorayProject.dto.CommentUpdateDto;
import com.nhnacademy.doorayProject.entity.Comment;
import com.nhnacademy.doorayProject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects/tasks")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/{taskId}")
    public String getComments(@RequestParam("taskId")Integer taskId, Model model){
        List<Comment> commentList = commentService.getComments(taskId);
        model.addAttribute("comments", commentList);
        return "/";
    }

    @PostMapping("/{taskId}/comments")
    public String createComment(@RequestParam("taskId")Integer taskId, @ModelAttribute CommentDto commentDto){
        commentService.postComment(taskId, commentDto);
        return "/task";
    }

    @PutMapping("/comments/{commentId}/update")
    public String updateComment(@RequestParam("commentId")Integer commentId, @ModelAttribute CommentUpdateDto commentUpdateDto) {
        commentService.updateCommemt(commentId, commentUpdateDto);
        return "/";
    }

    @DeleteMapping("/comments/{commentId}/delete")
    public String deleteComment(@RequestParam("commentId")Integer commentId) {
        commentService.deleteComment(commentId);
        return "/";
    }
}
