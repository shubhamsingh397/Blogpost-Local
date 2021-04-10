package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Post;
import com.example.demo.model.User;
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

	@Query
	public List<Post> findByUser(User user);
	@Query
	public Post findByPostTitle(String title);
	@Query
	public List<Post> findByTags(String tag);
	@Query
	public List<Post> findTop2ByOrderByTrendingRatingDesc();
}
