package com.example.Blogging.platform.API.dao;

import com.example.Blogging.platform.API.model.Post;
import com.example.Blogging.platform.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
   // @Query(value = "select * from post_model where user_id_user_id=:userId",nativeQuery = true)
    List<Post> findPostByUserId(User userModel);
}
