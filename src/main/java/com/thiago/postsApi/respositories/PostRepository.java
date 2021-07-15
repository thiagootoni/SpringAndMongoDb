package com.thiago.postsApi.respositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thiago.postsApi.models.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String title);

}
