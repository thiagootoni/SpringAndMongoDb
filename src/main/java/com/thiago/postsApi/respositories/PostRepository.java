package com.thiago.postsApi.respositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.thiago.postsApi.models.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String title);
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitleNativeQuery(String title);
	
	@Query("{ $and: [ { 'moment' : { $gte: ?1 }}, { 'moment' : { $lte: ?2 }}, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> searchForTextInAggregateStructure(String text, Instant startMoment, Instant endMoment);

}
