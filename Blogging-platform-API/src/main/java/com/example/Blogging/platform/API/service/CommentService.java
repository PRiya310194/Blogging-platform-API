package com.example.Blogging.platform.API.service;

import com.example.Blogging.platform.API.dao.CommentRepository;
import com.example.Blogging.platform.API.model.Comment;
import com.example.Blogging.platform.API.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    public int addComment(Comment commentData) {
        Comment saveComment=commentRepository.save(commentData);
        return saveComment.getCommentId();
    }

    public List<Comment> readAllComment() {
        return commentRepository.findAll();

    }

    public String readCommentById(Integer id) {
        if(commentRepository.findById(id).isPresent()){
            Comment comment= commentRepository.findById(id).get();
            return comment.toString();
        }
      else{
          return "please enter valid commentId";
        }

    }

    public boolean updateComment(int id, Comment comment) {
        if(commentRepository.findById(id).isPresent()){
            Comment comments=commentRepository.findById(id).get();
            comments.setComment(comment.getComment());
            User receiver=comment.getReceiver();
            comments.setReceiver(receiver);
            User sender=comment.getSender();
            comments.setSender(sender);
            commentRepository.save(comments);
            return true;
        }
        else{
            return false;
        }
    }


    public boolean deleteComment(int commentId) {
        if(commentRepository.findById(commentId).isPresent()){
            commentRepository.deleteById(commentId);
            return true;
        }
        else{
            return false;
        }
    }
}
