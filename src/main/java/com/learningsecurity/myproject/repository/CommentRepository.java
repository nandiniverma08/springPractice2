package com.learningsecurity.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningsecurity.myproject.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
}