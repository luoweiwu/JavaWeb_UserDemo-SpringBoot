package com.Gary.GaryuserDemo.service;

import java.util.List;

import com.Gary.GaryuserDemo.domain.User;


public interface UserService {
	void save(User user);
	boolean login(User user);
	List<User> findAll();
	User findById(Long id);
}
