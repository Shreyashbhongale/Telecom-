package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Connection;
import com.example.service.ConnectionService;
import com.example.util.Constants;

@RestController
@RequestMapping(value = Constants.ConnectionUri)
public class ConnectionController {
	
	@Autowired
	ConnectionService connectionService;
	
	@PostMapping("/save")
	public Connection saveConnection(@RequestBody Connection con) {
		
		
		Connection newCon=connectionService.saveConnection(con);
		
		return newCon;
		
	}
	
	@GetMapping("/getAll")
	public List<Connection> getAllConnection(){
		
		return connectionService.getAllConnection();
		
	}
	
	@GetMapping("/get/{Connection_id}")
	public ResponseEntity<Connection> getByID(@PathVariable("Connection_id") String Connection_id) {
		Connection emp=connectionService.getByID(Connection_id);
		return ResponseEntity.ok(emp);
	}
	
	@DeleteMapping("/delete/{Connection_id}")
	public void deleteConnection(@PathVariable("Connection_id")	String Connection_id) {
		connectionService.deleteConnection(Connection_id);		
	}
	@PutMapping("/update/{con_id}")
	public Connection updateConnection(@PathVariable("con_id") String con_id, @RequestBody Connection connection) {
		return connectionService.updateConnection(con_id, connection);
	}
	

}
