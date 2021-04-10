package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Post;

public interface PostService {

	public List<Post> getAllPost();
	public List<Post> getAllUserPost(String userName);
	public Post getPost(String userName,Long postId);
	public List<Post> getPostsByTags(String tags);
	public Boolean addLike(Long postId);
	public List<Post> getTrendingPosts();
	public Post createPost(Post post,String userName);
	public Post updatePost(Post post, String userName);
	public boolean deletePost(String userName,Long postId);
}
