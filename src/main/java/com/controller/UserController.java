package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;
	
	@PostMapping("/user")
	public String addUser(UserBean userBean)
	{
		System.out.println(userBean.getFirstName());
		System.out.println(userBean.getLastName());
		System.out.println(userBean.getEmail());
		System.out.println(userBean.getPassword());
		
		userDao.insertUser(userBean);
		return "user added";
	}
	@GetMapping("/users")
	public ArrayList<UserBean> listUsers()
	{
		return userDao.listUsers();
	}
	
	@GetMapping("/user/{email}")
	public UserBean getUser(@PathVariable("email") String email)
	{
		UserBean userBean=userDao.getUserByEmail(email);
		return userBean;
	}
	
	@DeleteMapping("/user/{email}")
	public ArrayList<UserBean> deleteUser(@PathVariable("email") String email)
	{
		userDao.deleteUser(email);
		
		return userDao.listUsers();
	}
	
	@PutMapping("/user/{email}")
	public ArrayList<UserBean> updateUser(UserBean userBean,@PathVariable("email") String email)
	{
		userDao.updateUser(userBean,email);
		return userDao.listUsers();
		
	}
}
