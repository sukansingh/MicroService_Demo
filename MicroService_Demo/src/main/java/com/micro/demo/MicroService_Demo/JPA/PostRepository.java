package com.micro.demo.MicroService_Demo.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.demo.MicroService_Demo.bean.Post;
import com.micro.demo.MicroService_Demo.bean.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
