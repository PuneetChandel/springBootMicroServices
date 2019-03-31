package com.pc.blogger.bloggerservice.bean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // repository for which entity and primary key
public interface PostRepository extends JpaRepository<Post,Integer>{

}