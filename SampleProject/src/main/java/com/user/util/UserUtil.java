package com.user.util;

import java.util.List;
import java.util.stream.Collectors;

import com.user.entity.UserDetails;

public class UserUtil{
	public static List<Integer> getUserIDs(List<UserDetails> userDetails){
		List<Integer> userIDs=userDetails.stream()
	            .map(UserDetails::getUserID)
	            .collect(Collectors.toList());
		return userIDs;
	}
	
}
