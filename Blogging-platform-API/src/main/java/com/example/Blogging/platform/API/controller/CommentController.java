package com.example.Blogging.platform.API.controller;
//import com.example.Blogging.platform.API.model.Comment;
import com.example.Blogging.platform.API.model.Comment;
import com.example.Blogging.platform.API.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping(value="/add-comment")
    public ResponseEntity<String> addComment(@RequestBody Comment commentData) {
        int commentId = commentService.addComment(commentData);
        return new ResponseEntity<>("Comment saved with id ->" + commentId, HttpStatus.CREATED);
    }

    @GetMapping(value="/findAll-comment")
    public ResponseEntity<List<Comment>> readAllComment() {
        List<Comment> commentList = commentService.readAllComment();
        return new ResponseEntity<>(commentList, HttpStatus.FOUND);
    }

    @GetMapping(value="findById/{id}")
    public ResponseEntity<String> readCommentById(@PathVariable Integer id) {
        if (id != null) {
            String comment = commentService.readCommentById(id);
            return new ResponseEntity<>(comment, HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>("please enter valid commentId ->",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value="/update/{id}")
    public ResponseEntity<String>updateComment(@PathVariable int id,@RequestBody Comment comment){
        boolean ans=commentService.updateComment(id,comment);
        if(ans){
            return new ResponseEntity<>("updated successfully",HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("please enter valid commentId",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value="/deleteComment/{commentId}")
    public ResponseEntity<String>deleteComment(@PathVariable Integer commentId){
        boolean ans=commentService.deleteComment(commentId);
        if(ans){
            return new ResponseEntity<>("comment deleted with id "+commentId,HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>("please enter valid id",HttpStatus.BAD_REQUEST);
        }
    }
}
