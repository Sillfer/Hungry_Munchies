package com.blog.service;

import com.blog.model.Post;
import com.blog.model.User;
import com.blog.repository.PostRepository;
import com.blog.repository.UserRepository;
import com.blog.security.jwt.JwtUtils;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    public Boolean isEmpty() {
        return repository.findAll().isEmpty();
    }

    public Post save(Post post) {
//        set author to null if author id is null
        if (post.getAuthor() != null && post.getAuthor().getId() == null) {
            post.setAuthor(null);
        }
        post.setUpdated_at(new Date());
        return repository.save(post);
    }

//    public Post create(Post post, String token) throws NotFoundException {
//        Long authorId = jwtUtils.extractUserId(token);
//        User author = userRepository.findById(authorId).orElseThrow(() -> new NotFoundException("User not found"));
//        post.setAuthor(author.getAuthor());
//        post.setUpdated_at(new Date());
//        return repository.save(post);
//    }

    public String deletePost(Long id) {
        Post post = repository.getOne(id);

        repository.delete(post);

        return "Post deleted";
    }

    public List<Post> getAll() {
        return repository.findAll();
    }

    public Post getPost(Long id) {
        Post post = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Post is not found."));

        if (post.getAuthor() == null) {
            return post;
        }

        post.getAuthor().getId();

        return post;
    }


}
