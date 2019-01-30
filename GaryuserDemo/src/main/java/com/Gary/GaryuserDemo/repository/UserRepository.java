package com.Gary.GaryuserDemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.Gary.GaryuserDemo.domain.User;

public interface UserRepository extends CrudRepository<User,Long>{

	User findByUsernameAndPassword(String username, String password);

}
