package com.blog.repository;

import com.blog.model.ECategory;
import com.blog.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByAuthorId(Long id);
    List<Post> findByCategory(ECategory category);
    List<Post> findByStatus(Status status);
}


//(nbrCou * 100)/totalCountry
