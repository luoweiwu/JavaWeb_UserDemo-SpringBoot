package com.Gary.GaryuserDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Gary.GaryuserDemo.domain.User;
import com.Gary.GaryuserDemo.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("/index.html");
	}
	
	@RequestMapping("/register.action")
	public ModelAndView register(User user) {
		userServiceImpl.save(user);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/login.action")
	public ModelAndView login(User user) {
		boolean success = userServiceImpl.login(user);
		if(success) {
			return new ModelAndView("/welcome.html");
		}else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping("/show.action")
	public ModelAndView show(Model model) {
		
		List<User> userList = userServiceImpl.findAll();
		//把userList放入到模型中
		model.addAttribute("userList",userList);
		return new ModelAndView("/show-all-user.html","userModel",model);
	}
	
	@RequestMapping("/toEdit/{id}")
	public ModelAndView toEdit(@PathVariable("id")Long id,Model model) {
		//根据ID得到用户
		User user = userServiceImpl.findById(id);
		//将用户放入到model中
		model.addAttribute("user",user);
		return new ModelAndView("/edit-user.html","userModel",model);
	}
	
	@RequestMapping("/edit.action")
	public ModelAndView Edit(User user) {
		userServiceImpl.save(user);
		return new ModelAndView("redirect:/show.action");
	}
	
}
