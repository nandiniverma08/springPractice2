package com.learningsecurity.myproject.controller;

import java.util.List;

import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CommentController {
	
//	@Autowired
//	private PostService postService;
//	
//	@Autowired
//	private CommentService commentService;
	
//	@GetMapping("/post/{postId}/comments")
//	public Comment getAllCommentsByPostId(@PathVariable(value="postId") int postId){
//		if (!postService.existsById(postId)) {
//			throw new ResourceNotFoundException("Not found Post with id = " + postId);
//		}
//		List<Comment> comments = commentService.findByPostId(postId);
//	    return new Comment(comments);
//	}
//	
//	@GetMapping("/posts/{id}")
//	  public Comment getPostById(@PathVariable("id") int id) {
//	    Comment comment = ((Comment) PostService.findById(id)).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
//
//	    return new Comment();
//	  }

//	  @PostMapping("/posts")
//	  public Comment createComment(@RequestBody Comment comment) {
//		  System.out.println("Post Data to be Saved"+comment.toString());
//		  Post _post = postService.save(new Post());
//		  return new Comment();
//	  }

}
