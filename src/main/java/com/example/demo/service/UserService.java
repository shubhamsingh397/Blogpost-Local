package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

	public User addUser(User user);
	public List<User> getAllUser();
	public User getUser(String userName);
	public User updateUser(User user);
	public boolean deleteUser(String userName);
}
