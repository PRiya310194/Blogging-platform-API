package com.example.Blogging.platform.API.controller;

import com.example.Blogging.platform.API.dao.UserRepository;
import com.example.Blogging.platform.API.model.Post;
import com.example.Blogging.platform.API.model.User;
import com.example.Blogging.platform.API.service.PostService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.List;

@RestController
//@RequestMapping(value="/api/v1/post")

public class PostController {
    @Autowired
    PostService postService;
@Autowired
    UserRepository userRepository;
    @PostMapping(value="save-post")
    public ResponseEntity<String> savePost(@RequestBody Post postRequest){
        int postId=postService.savePost(postRequest);
        return new ResponseEntity<>("post saved with id "+postId,HttpStatus.OK);
    }
@GetMapping(value="/post/{postId}")
    public ResponseEntity<String>readPost(@PathVariable Integer postId){
     if(postId!=null){
Post post=postService.readPost(postId);
return new ResponseEntity<>(post.toString(),HttpStatus.FOUND);

     }
     else{
         return new ResponseEntity<>("please enter valid postId",HttpStatus.BAD_REQUEST);
     }
}
@GetMapping(value="readAllPost")
    public ResponseEntity<List<Post>>readAllPost(){
        List<Post>post=postService.readAllPost();
        return new ResponseEntity<>(post,HttpStatus.FOUND);
}
    @PutMapping(value="/update-post/{postId}")
    public ResponseEntity<String>updatePost(@PathVariable Integer postId, @RequestBody Post post){
        boolean ans=postService.updatePost(postId,post);
if(ans){
return new ResponseEntity<>("post updated successfully",HttpStatus.OK);
}
else{
    return new ResponseEntity<>("please enter valid postId",HttpStatus.BAD_REQUEST);
}
    }
@DeleteMapping(value="/deletePost/{postId}")
    public ResponseEntity<String>deletePost(@PathVariable Integer postId){
        boolean ans=postService.deletePost(postId);
if(ans){
    return new ResponseEntity<>("post deleted successfully",HttpStatus.OK);
}
else{
    return new ResponseEntity<>("please enter valid postId",HttpStatus.BAD_REQUEST);
}
}
    @GetMapping("post-user/{userId}")
    public ResponseEntity<List<Post>> postUser(@PathVariable Integer userId){
        List<Post> list=postService.postAndUsers(userId);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
