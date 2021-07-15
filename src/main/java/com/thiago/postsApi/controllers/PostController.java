package com.thiago.postsApi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.postsApi.models.dto.PostDto;
import com.thiago.postsApi.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	PostService service;

	@GetMapping
	public ResponseEntity<List<PostDto>> findAll() {
		List<PostDto> posts = service.findAll();
		return ResponseEntity.ok(posts);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDto> findById(@PathVariable String id) {
		PostDto userDto = service.findById(id);
		return ResponseEntity.ok(userDto);
	}
	
	@GetMapping(value = "/titleSearch")
	public ResponseEntity<List<PostDto>> findByTitle(@RequestParam(value="text", defaultValue = "") String text){
		List<PostDto> posts = this.service.findByTitleContainingSentence(text);
		return ResponseEntity.ok(posts);
	}
	
	@GetMapping(value = "/fullSearch")
	public ResponseEntity<List<PostDto>> findByTitle(
			@RequestParam(value="text", defaultValue = "") String text,
			@RequestParam(value="startDate", defaultValue = "") String startDate,
			@RequestParam(value="endDate", defaultValue = "") String endDate){
		
		List<PostDto> posts = this.service.findForAnyMatchInAggregateStructure(text, startDate, endDate);
		return ResponseEntity.ok(posts);
	}
	
	

}
