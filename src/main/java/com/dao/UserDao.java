package com.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	ArrayList<UserBean> users=new ArrayList<>();

	public void insertUser(UserBean userBean) {
		users.add(userBean);
		
	}

	public ArrayList<UserBean> listUsers() {
		return users;
	}

	public UserBean getUserByEmail(String email) {
		for(UserBean u: users)
		{
			if(u.getEmail().equals(email))
			{
				return u;
			}
		}
		return null;
	}

	public void deleteUser(String email) {
		for(UserBean u:users)
		{
			if(u.getEmail().equals(email))
			{
				users.remove(u);
				break;
				
			}
		}
		
	}

	public void updateUser(UserBean userBean, String email) {
		for(UserBean u:users)
		{
			if(u.getEmail().equals(email))
			{
				try {
				if(!userBean.getEmail().equals(null))
				{
					u.setEmail(userBean.getEmail());
				}
				}catch(Exception e){
					u.setEmail(u.getEmail());
				}
				try {
				if(!userBean.getFirstName().equals(null))
				{
					u.setFirstName(userBean.getFirstName());
				}
				}catch(Exception e)
				{
					u.setFirstName(u.getFirstName());
				}
				
				try {
				if(!userBean.getLastName().equals(null))
				{
					u.setLastName(userBean.getLastName());
				}
				}catch(Exception e)
				{
					u.setLastName(u.getLastName());
				}
				try {
				if(!userBean.getPassword().equals(null))
				{
					u.setPassword(userBean.getPassword());
				}
				}catch(Exception e)
				{
					u.setPassword(u.getPassword());
				}
				
			//	u.setFirstName(userBean.getFirstName());
			//u.setLastName(userBean.getLastName());
				
			}
		}
		
	}
	
	
}
