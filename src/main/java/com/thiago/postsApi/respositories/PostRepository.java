package com.thiago.postsApi.respositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thiago.postsApi.models.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
