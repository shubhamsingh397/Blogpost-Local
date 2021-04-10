package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long postId;

	private String postTitle;
	private String postSubtitle;
	@Column(name = "body", columnDefinition = "TEXT")
	private String body;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
	private Collection<Comment> comments;
	@OneToMany
	private Collection<Image> images = new ArrayList<Image>();
    private Date createDate;
    private Date updateDate;
    
    private int likesCount = 0;
   
    private int views = 0;
    private String tags;
    private int trendingRating = 0;
    
    
    
	

	public int getTrendingRating() {
		return trendingRating;
	}

	public void setTrendingRating(int trendingRating) {
		this.trendingRating = trendingRating;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	

	public String getTags() {
		return tags;
	}
	
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getLikesCount() {
		return likesCount;
	}
	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}
	
	public Collection<Image> getImages() {
		return images;
	}
	public void setImages(Collection<Image> images) {
		this.images = images;
	}
	
	public String getPostSubtitle() {
		return postSubtitle;
	}
	public void setPostSubtitle(String postSubtitle) {
		this.postSubtitle = postSubtitle;
	}
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Collection<Comment> getComments() {
		return comments;
	}
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTitle=" + postTitle + ", body=" + body + ", createDate=" + createDate
				+ "]";
	}
	
	
}
