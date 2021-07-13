package com.thiago.postsApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.postsApi.models.dto.UserDto;
import com.thiago.postsApi.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll(){
		
		List<UserDto> users = service.findAll();		
		return ResponseEntity.ok(users);
	}

}
