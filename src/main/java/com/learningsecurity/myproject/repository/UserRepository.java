package com.learningsecurity.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learningsecurity.myproject.entity.MyUser;


@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer>{
	
	@Query("select myuser from MyUser myuser where myuser.userName = :userName")
	  public MyUser findByUserName(@Param("userName") String userName);

}
