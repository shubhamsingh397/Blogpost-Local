package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ImageRepository;
import com.example.demo.dao.PostRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Image;
import com.example.demo.model.Post;
import com.example.demo.model.User;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepo;
	private UserRepository userRepo;
	private ImageRepository imageRepo;
	
	@Autowired
	public PostServiceImpl(PostRepository postRepo, UserRepository userRepo,ImageRepository imageRepo) {
		this.postRepo = postRepo;
		this.userRepo = userRepo;
		this.imageRepo = imageRepo;
	}
	
	@Override
	public List<Post> getAllPost() {
		return postRepo.findAll();
		
	
	}

	@Override
	public List<Post> getAllUserPost(String userName) {
		User user = userRepo.findByUserName(userName);
		List<Post> posts = postRepo.findByUser(user);
		return posts;
	}

	@Override
	public Post getPost(String userName, Long postId) {
		
		User user = userRepo.findByUserName(userName);
		if(user!=null)
		{
			Post post = postRepo.findById(postId).get();
			post.setViews(post.getViews()+1);
			post.setTrendingRating(post.getTrendingRating()+1);
			
			return postRepo.save(post);
		}
			
		else return null;
		
	}

	@Override
	public Post createPost(Post post, String userName) {
		
		
		User user = userRepo.findByUserName(userName);
		if (user != null) {
			post.setCreateDate(new Date());
			post.setUser(user);
			List<Image> images = new ArrayList<Image>();
			Iterator<Image> iterator = post.getImages().iterator();
			while(iterator.hasNext())
			{
				Image image = iterator.next();
				images.add(image);
				imageRepo.save(image);
			}
			
			post.setImages(images);
			return postRepo.save(post);
		} else
			return null;
	}

	@Override
	public Post updatePost(Post post, String userName) {
		User user = userRepo.findByUserName(userName);
		if(user != null)
		{
			Post existingPost = postRepo.findByPostTitle(post.getPostTitle());
			existingPost.setBody(post.getBody());
			existingPost.setUpdateDate(new Date());
			Collection<Image> images2 = existingPost.getImages();
			existingPost.setImages(null);
			imageRepo.deleteAll(images2);
			List<Image> images = new ArrayList<Image>();
			Iterator<Image> iterator = post.getImages().iterator();
			while(iterator.hasNext())
			{
				Image image = iterator.next();
				images.add(image);
				imageRepo.save(image);
			}
			
			existingPost.setImages(images);
			return postRepo.save(existingPost);
		}
		else
			return null;
	}

	@Override
	public boolean deletePost(String userName, Long postId) {
		User user = userRepo.findByUserName(userName);
		if(user!=null)
		{
			postRepo.deleteById(postId);
			return true;
		}
		else return false;
		
	}

	@Override
	public List<Post> getPostsByTags(String tags) {
		
		return postRepo.findByTags(tags);
	}

	@Override
	public Boolean addLike(Long postId) {
		// TODO Auto-generated method stub
		Post post = postRepo.findById(postId).get();
		
		post.setLikesCount(post.getLikesCount()+1);
		post.setTrendingRating(post.getTrendingRating()+ post.getLikesCount()*2);
		Post post2 = postRepo.save(post);
		if(post2!=null)
			return true;
		else return false;
	}

	@Override
	public List<Post> getTrendingPosts() {
		return postRepo.findTop2ByOrderByTrendingRatingDesc();
		
	}

	
}
