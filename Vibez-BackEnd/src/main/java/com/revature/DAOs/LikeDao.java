package com.revature.DAOs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Like;

@Repository
public interface LikeDao extends JpaRepository<Like, Integer> {
    
    List<Like> findByPostId(int postId);
}