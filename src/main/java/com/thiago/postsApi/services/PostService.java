package com.thiago.postsApi.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.postsApi.models.dto.PostDto;
import com.thiago.postsApi.models.entities.Post;
import com.thiago.postsApi.respositories.PostRepository;
import com.thiago.postsApi.services.exceptions.ElementNotFoundException;
import com.thiago.postsApi.utils.DateConversors;

@Service
public class PostService {
	
	@Autowired
	PostRepository repository;
	
	public List<PostDto> findAll(){
		List<Post> posts = this.repository.findAll();
		return posts.stream().map(x -> new PostDto(x)).collect(Collectors.toList());
	}

	public PostDto findById(String id) {		
		Post post = getPostById(id);
		return new PostDto(post);
	}

	public void deleteOne(String id) {
		Post post = this.getPostById(id);
		this.repository.delete(post);		
	}
	
	public List<PostDto> findByTitleContainingSentence(String sentence){		
		List<Post> posts = this.repository.findByTitleContainingIgnoreCase(sentence);
		return posts.stream().map(x -> new PostDto(x)).collect(Collectors.toList());		
	}
	
	public List<PostDto> findForAnyMatchInAggregateStructure(String text, String start, String end){
		Instant startDate = DateConversors.stringToInstant(start, Instant.ofEpochMilli(0));
		Instant endDate = DateConversors.stringToInstant(end, Instant.now());
		List<Post> posts = this.repository.searchForTextInAggregateStructure(text, startDate, endDate);
		return posts.stream().map(x -> new PostDto(x)).collect(Collectors.toList());
	}

	private void copyDtoToEntity(PostDto postDto, Post post) {
		//post.setId(postDto.getId());
		post.setAuthor(postDto.getAuthor());
		post.setBody(postDto.getBody());		
		post.setMoment(postDto.getMoment());
		post.setTitle(post.getTitle());
	}
	
	private Post getPostById(String id) {
		return this.repository.findById(id)
				.orElseThrow(() -> new ElementNotFoundException("Elemento não encontrado"));
	}
}
