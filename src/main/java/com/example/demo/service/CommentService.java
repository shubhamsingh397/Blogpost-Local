package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Comment;

public interface CommentService {

	public Comment addComment(Comment comment,Long postId,String userName);
	public List<Comment> getAllComment(Long postId);
	public boolean deleteComment(Long commentId);
	
}
