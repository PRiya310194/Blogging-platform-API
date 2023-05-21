package com.example.Blogging.platform.API.service;

import com.example.Blogging.platform.API.dao.FollowRepository;
import com.example.Blogging.platform.API.dao.UserRepository;
import com.example.Blogging.platform.API.model.Follow;
import com.example.Blogging.platform.API.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private UserRepository userRepository;
    public String followings(Integer id1,Integer id2) {
     if(userRepository.findById(id1).isPresent() && userRepository.findById(id2).isPresent()){
        User userModel = userRepository.findById(id2).get();
        User userModel1 = userRepository.findById(id1).get();
        Follow follow=new Follow();
        follow.setFollowingUsers(userModel);
        follow.setUser(userModel1);
        Follow save = followRepository.save(follow);
        return save.toString();
    }
        else if(!userRepository.findById(id1).isPresent()){
        return "user 1 is not present";
    }
        else if(!userRepository.findById(id2).isPresent()) {
        return "user 2 is not present";
    }
        return "user 1 and user 2 are not present";
}

    public Follow watchFollowers(Integer yourId) {
        if(userRepository.findById(yourId).isPresent()) {
            return followRepository.findById(yourId).get();
        }
        return null;
    }
}
