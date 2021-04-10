package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;

@RestController
@RequestMapping(value = "/post")
@CrossOrigin("http://localhost:3000")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping(value = "/addPost/{userName}")
	public Post addPost(@RequestBody Post post,@PathVariable ("userName") String userName)
	{
		return postService.createPost(post, userName);
	}
	
	@GetMapping(value = "/{userName}")
	public List<Post> getAllUserPost(@PathVariable("userName")String userName)
	{
		return postService.getAllUserPost(userName);
	}
	
	@PutMapping(value = "/{userName}")
	public Post updatePost(@PathVariable("userName")String userName,@RequestBody Post post)
	{
		return postService.updatePost(post, userName);
	}
	
	@GetMapping
	public List<Post> getAllPosts()
	{
		return postService.getAllPost();
	}
	
	@GetMapping(value="/trending")
	public List<Post> getTrendingPosts()
	{
		return postService.getTrendingPosts();
	}
	
	@PostMapping(value = "/addlike/{postId}")
	public Boolean addLike(@PathVariable("postId")Long postId)
	{
		return postService.addLike(postId);
	}
	
	@GetMapping(value = "/{tags}")
	public List<Post> getPostByTags(@PathVariable("tags")String tags)
	{
		return postService.getPostsByTags(tags);
	}
	
	@GetMapping(value = "/{userName}/{postId}")
	public Post getPostByTitle(@PathVariable("userName")String userName,@PathVariable("postId") Long postId)
	{
		return postService.getPost(userName, postId);
	}
	
	@DeleteMapping(value = "/{userName}/{postId}")
	public Boolean deletePost(@PathVariable("userName")String userName,@PathVariable("postId")Long postId)
	{
		return postService.deletePost(userName, postId);
	}
}
