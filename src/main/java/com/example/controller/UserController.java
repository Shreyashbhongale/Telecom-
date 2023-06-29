package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Connection;
import com.example.entity.User;
import com.example.service.ConnectionService;
import com.example.service.UserService;
import com.example.util.Constants;

@RestController
@RequestMapping(value = Constants.UserUri)
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	ConnectionService connectionService;
	
	@PostMapping(value = Constants.Save)
	public User saveUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		
		List<Connection> conncetionList= user1.getConnectionList();
		
		for (Connection con : conncetionList) {
			con.setCon_id(user1.getUser_id());
			connectionService.saveConnection(con);
		}
		return user1;
	}
	
}
