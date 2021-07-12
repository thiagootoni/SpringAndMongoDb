package com.thiago.postsApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostsApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PostsApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Tá no ar!");
		
	}

}
