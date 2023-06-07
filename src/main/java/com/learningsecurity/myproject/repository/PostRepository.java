package com.learningsecurity.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningsecurity.myproject.entity.Post;



@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
