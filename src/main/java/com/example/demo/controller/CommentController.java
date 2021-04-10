package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;

@RestController
@RequestMapping(value = "/comments")
@CrossOrigin("*")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping(value = "/{postId}/{userName}")
	public Comment addComment(@RequestBody Comment comment, @PathVariable("postId")Long postId,@PathVariable("userName")String userName)
	{
		return commentService.addComment(comment, postId, userName);
	}
	
	@GetMapping(value = "/{postId}")
	public List<Comment> getAllComments(@PathVariable("postId")Long postId)
	{
		return commentService.getAllComment(postId);
	}
	
	@DeleteMapping(value = "/{commentId}")
	public boolean deleteComment(@PathVariable("commentId")Long commentId)
	{
		return commentService.deleteComment(commentId);
	}
}
