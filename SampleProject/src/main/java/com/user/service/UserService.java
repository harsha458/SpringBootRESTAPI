package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.UserDAO;
import com.user.entity.UserDetails;
@Service
public class UserService {
	@Autowired 
	UserDAO userDAO;
	
	public List<UserDetails> getUsers(){
		return userDAO.getUsers();
	}
	
	public UserDetails getUserById(int id){
		return userDAO.getUserByID(id);
	}

	public UserDetails getUser(){
		return userDAO.getUser();
	}
}
