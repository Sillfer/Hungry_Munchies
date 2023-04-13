package com.blog.service;

import com.blog.model.ECategory;
import com.blog.model.Post;
import com.blog.model.Status;
import com.blog.model.User;
import com.blog.repository.PostRepository;
import com.blog.repository.UserRepository;
import com.blog.security.jwt.JwtUtils;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<Post> getPostByCategory(ECategory category){
        return  repository.findByCategory(category);
    }

    public String deletePost(Long id) {
        Post post = repository.getOne(id);

        repository.delete(post);

        return "Post deleted";
    }

    public List<Post> getRecipesByAuthorId(Long id) {
        return repository.findAllByAuthorId(id);
    }

    public List<Post> getThreeRandomPosts() {
        List<Post> allPosts = repository.findAll();
        List<Post> randomPosts = new ArrayList<>();

        // Shuffle the list of posts
        Collections.shuffle(allPosts);

        for (int i = 0; i < Math.min(3, allPosts.size()); i++) {
            randomPosts.add(allPosts.get(i));
        }

        return randomPosts;

    }


    public List<Post> getAll() {
        return repository.findAll();
    }

    public List<Post> getAllPending(){
        return repository.findByStatus(Status.PENDING);
    }

    public void publishPost(Long id){
        Post post = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post Not Found"));
        post.setStatus(Status.PUBLISHED);
        repository.save(post);
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
