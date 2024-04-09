package com.web.service.restproject.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.service.restproject.model.RestUser;

@RestController
@RequestMapping("/users")
public class Controller {
	
	Map<String,RestUser>allUsers=new HashMap<>();
	
	@GetMapping
	public Collection<RestUser> getmethod()
	{
		
		return allUsers.values();
	}
	@PutMapping (path="/{userId}")
	public String putmethod(@PathVariable String userId,@RequestBody RestUser userdetails)
	{
		if(allUsers.containsKey(userId))
		{
			RestUser addValue=new RestUser();
			
			addValue.setUserId(userdetails.getUserId());
			addValue.setName(userdetails.getName());
			addValue.setEmail(userdetails.getEmail());
			allUsers.put(userId, addValue);
			return"User details updated";
		}
		else
		{
			return "user id not found";
		}
		
	
		
	}
	@PostMapping
	public String postmethod(@RequestBody RestUser userdetails)
	{
		RestUser addValue=new RestUser();
		
		addValue.setUserId(userdetails.getUserId());
		addValue.setName(userdetails.getName());
		addValue.setEmail(userdetails.getEmail());
		allUsers.put(userdetails.getUserId(), addValue);
		return"User added";
		
	}
	@DeleteMapping(path="/{userId}")
	public String deletemethod(@PathVariable String userId)
	{
		if(allUsers.containsKey(userId))
		{
			allUsers.remove(userId);
			return "User deleted succussfully";
		}
		else
		{
			return "UserId not found";
		}
		
	}
	
}
