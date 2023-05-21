package com.example.Blogging.platform.API.dao;

import com.example.Blogging.platform.API.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Integer> {
}
