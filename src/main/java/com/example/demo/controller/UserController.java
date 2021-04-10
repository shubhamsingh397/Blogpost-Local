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

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/addUser")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	@GetMapping(value = "/{userName}")
	public User getUser(@PathVariable("userName")String userName)
	{
		return userService.getUser(userName);
	}
	@GetMapping
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	@PutMapping
	public User updateUser(@RequestBody User user)
	{
		return userService.updateUser(user);
	}
	@DeleteMapping(value = "/{userName}")
	public boolean deleteUser(@PathVariable("userName")String userName)
	{
		return userService.deleteUser(userName);
	}
}