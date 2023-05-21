package com.example.Blogging.platform.API.service;

import com.example.Blogging.platform.API.dao.PostRepository;
import com.example.Blogging.platform.API.dao.UserRepository;
import com.example.Blogging.platform.API.model.Post;
import com.example.Blogging.platform.API.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    public int savePost(Post post) {
        Post Savepost = postRepository.save(post);
        return Savepost.getPostId();
    }

    public Post readPost(Integer postId) {
        return postRepository.findById(postId).get();
    }


    public List<Post> readAllPost() {
        return postRepository.findAll();
    }

    public boolean updatePost(Integer postId, Post post) {
        if (postRepository.findById(postId).isPresent()) {
            Post postData = postRepository.findById(postId).get();
            postData.setPostName(post.getPostName());
            postData.setPostDescription(post.getPostDescription());
            Post save = postRepository.save(postData);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePost(Integer postId) {
        if (postRepository.findById(postId).isPresent()) {
            postRepository.deleteById(postId);
            return true;
        } else {
            return false;
        }

    }


        public List<Post> postAndUsers (Integer userId){
            if (userRepository.findById(userId).isPresent()) {
                User userModel = userRepository.findById(userId).get();
                return postRepository.findPostByUserId(userModel);
            } else {
                return new ArrayList<>();
            }
        }
    }




