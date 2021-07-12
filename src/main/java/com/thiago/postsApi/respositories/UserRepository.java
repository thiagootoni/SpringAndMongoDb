package com.thiago.postsApi.respositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thiago.postsApi.models.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
