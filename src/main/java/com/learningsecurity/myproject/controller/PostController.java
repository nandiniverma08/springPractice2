package com.learningsecurity.myproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningsecurity.myproject.entity.Post;
import com.learningsecurity.myproject.service.PostService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/post/{id}")
	public Post getPostById(@PathVariable int id) {
		return ((PostService) postService).getPostById(id);
	}
	
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		Post post=new Post();
		post.setName("Anisha");
		post.setMessage("Public Api");
		List<Post> posts=new ArrayList<>();
		posts.add(post);
		
		return posts;
	}
	
	@PostMapping("/post")
	public Post addPost(@RequestBody Post post) {
		System.out.println("Post Data to be Saved"+post.toString());
		return (Post) this.postService.addPost(post);
	}
	
	@PutMapping("/updatepost")
	public Post updatePost(@RequestBody Post post) {
		return postService.updatePost(post);
	}
}
	
//	@PostMapping("/posts")
//	public List<Post> addUsers(@RequestBody List<Post> posts){
//		System.out.println("Post Data to be Saved"+posts.toString());
//		return this.postService.addPosts(posts);
//	}

