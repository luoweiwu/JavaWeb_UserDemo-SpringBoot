package com.Gary.GaryuserDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gary.GaryuserDemo.domain.User;
import com.Gary.GaryuserDemo.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void save(User user) {
		userRepository.save(user);	
	}

	@Override
	public boolean login(User user) {
		User loginUser = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		
		return loginUser==null?false:true;
	}

	@Override
	public List<User> findAll() {
		Iterable<User> list = userRepository.findAll();
		return (List<User>)list;
	}

	@Override
	public User findById(Long id) {
		 Optional<User> user = userRepository.findById(id);
		return user.get();
	}




}
