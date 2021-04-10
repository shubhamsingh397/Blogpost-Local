package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommentRepository;
import com.example.demo.dao.PostRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.User;

@Service
public class CommentServiceImpl implements CommentService{

	private CommentRepository commentRepo;
	private UserRepository userRepo;
	private PostRepository postRepo;
	private List<Comment> comments = new ArrayList<Comment>();
	@Autowired
	public CommentServiceImpl(CommentRepository commentRepo, UserRepository userRepo, PostRepository postRepo) {
		this.commentRepo = commentRepo;
		this.postRepo = postRepo;
		this.userRepo = userRepo;
	}
	@Override
	public Comment addComment(Comment comment, Long postId, String userName) {
		Post post = postRepo.findById(postId).get();
		User user = userRepo.findByUserName(userName);
		comments.add(comment);
		post.setComments(comments);
		post.setTrendingRating(post.getTrendingRating()+ post.getTrendingRating()*5);
		comment.setPost(post);
		comment.setUser(user);
		comment.setCreateDate(new Date());
		postRepo.save(post);
		return commentRepo.save(comment);
		
	}

	@Override
	public List<Comment> getAllComment(Long postId) {
		Post post = postRepo.getOne(postId);
		return commentRepo.findByPost(post);
	}

	@Override
	public boolean deleteComment(Long commentId) {
		if(commentRepo.existsById(commentId))
		{
			commentRepo.deleteById(commentId);
			return true;
		}
		else return false;
	}

}
