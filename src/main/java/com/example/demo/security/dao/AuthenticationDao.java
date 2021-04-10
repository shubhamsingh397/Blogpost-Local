package com.example.demo.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;


@Repository
public interface AuthenticationDao extends JpaRepository<User, Long> {

	@Query
	public User findByUserName(String username);
}
