package com.learningsecurity.myproject.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningsecurity.myproject.entity.Comment;
import com.learningsecurity.myproject.entity.Post;
import com.learningsecurity.myproject.repository.PostRepository;


@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@OneToMany
	private Set<Comment> comment=new HashSet<>();

	public Post addPost(Post post) {
		// TODO Auto-generated method stub
		System.out.println("Inside Service Package"+post.toString());
		post.setCreated(new Date());
		
		return postRepository.save(post);
	}

	public List<Post> getPosts() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

	public Post getPostById(int id) {
		// TODO Auto-generated method stub
		return postRepository.findById(id).orElse(null);
	}

	public Post updatePost(Post post) {
		// TODO Auto-generated method stub
		Post oldPost=null;
		Optional<Post> optionalpost=postRepository.findById((int) post.getId());
		if(optionalpost.isPresent()) {
			oldPost=optionalpost.get();
			oldPost.setName(post.getName());
			oldPost.setMessage(post.getMessage());
			oldPost.setDescription(post.getDescription());
			postRepository.save(oldPost);
		}else {
			return new Post();
		}
		return oldPost;
	}

	public boolean existsById(int postid) {
		// TODO Auto-generated method stub
		return false;
	}

	public static Comment findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Post save(Post post) {
		System.out.println("Inside Service Package"+post.toString());
		post.setCreated(new Date());
		// TODO Auto-generated method stub
		return postRepository.save(post);
	}
}

//	public List<Post> addPosts(List<Post> posts) {
//		
//		System.out.println("Inside Service Package"+posts.toString());
//		((Post) posts).setCreated(new Date());
//		
//		posts = new ArrayList<>();
//		postRepository.saveAll(posts);
//			return posts;
//		
//		// TODO Auto-generated method stub
//		//return postRepository.saveAll(posts);
//	}
//

