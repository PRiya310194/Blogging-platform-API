package com.example.Blogging.platform.API.dao;

import com.example.Blogging.platform.API.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository <Comment,Integer>{

}
