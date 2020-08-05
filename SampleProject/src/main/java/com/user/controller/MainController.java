package com.user.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.entity.UserDetails;
import com.user.service.UserService;
import com.user.util.UserUtil;
@RestController
public class MainController {
	@Autowired
	UserService userService;
	ObjectMapper mapper=new ObjectMapper();
	
	@RequestMapping("/user")
	 public String user(){
		Map<String,String> userMap=new HashMap<>();
		userMap.put("Name", "Vardhan");
		userMap.put("RollNo", "120");
		userMap.put("College", "GMRIT");
		return userMap.toString();
	}
	
	@RequestMapping("/getUsers")
	 public List<UserDetails> getUsers(){
		List<UserDetails> details=userService.getUsers();
		return details;
	}
	
	@RequestMapping("/User/{id}")
	 public UserDetails getUserById(@PathVariable("id") String  id){
		int userID=Integer.valueOf(id);
		UserDetails details=userService.getUserById(userID);
		return details;
	}
		
	@RequestMapping("/UserDet")
	 public UserDetails getUser(){
		UserDetails details=userService.getUser();
		return details;
	}
	
	@RequestMapping("/IDs")
	 public List<Integer> getUserID(){
		List<UserDetails> details=userService.getUsers();
		return UserUtil.getUserIDs(details);
	}
	
}
