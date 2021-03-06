package com.thiago.postsApi.controllers;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thiago.postsApi.models.dto.PostDto;
import com.thiago.postsApi.models.dto.UserDto;
import com.thiago.postsApi.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {

		List<UserDto> users = service.findAll();
		return ResponseEntity.ok(users);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable String id) {

		UserDto userDto = service.findById(id);
		return ResponseEntity.ok(userDto);
	}
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<PostDto>> findUserPosts (@PathVariable String id){
		List<PostDto> posts = this.service.findUserPosts(id);
		return ResponseEntity.ok(posts);
	}
	
	@PostMapping
	public ResponseEntity<UserDto> insertOne(@RequestBody UserDto userDto){
		
		userDto = this.service.insertOne(userDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDto.getId()).toUri();
		return ResponseEntity.created(uri).body(userDto);
	}
	
	@PutMapping
	public ResponseEntity<UserDto> updateOne(@RequestBody UserDto userDto, @PathVariable String id){
		
		userDto = this.service.updateOne(userDto, id);
		return ResponseEntity.ok(userDto);
		
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteOne(@PathVariable String id){
		this.service.deleteOne(id);
		return ResponseEntity.noContent().build();
	}

}
