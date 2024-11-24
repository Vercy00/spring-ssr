package org.example.springssr.repository;

import org.example.springssr.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {
}
