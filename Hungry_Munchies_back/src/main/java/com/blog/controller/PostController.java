package com.blog.controller;

import com.blog.model.Post;
import com.blog.payload.PostDTO;
import com.blog.service.AuthorService;
import com.blog.service.PostService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService service;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/all")
    public List<PostDTO> getAllPosts() {
        List<Post> posts = service.getAll();
        List<PostDTO> postDTOs = new ArrayList<>();
        for (Post post : posts) {
            PostDTO postDTO = new PostDTO(post.getId(), post.getTitle(), post.getImage(), post.getContent(), post.getAuthor().getId(), post.getCreated_at(), post.getUpdated_at());
            postDTOs.add(postDTO);
        }
        return postDTOs;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> show(@PathVariable Long id) {
        Post post = service.getPost(id);
        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post newPost = service.save(post);
        System.out.println(newPost);
        if (newPost != null) {
            return new ResponseEntity<>(newPost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping("/create")
//    public ResponseEntity<Post> createPost(@RequestBody Post post, @RequestHeader("Authorization") String token) {
//        try {
//            Post newPost = service.create(post, token);
//            if (newPost != null) {
//                return new ResponseEntity<>(newPost, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//            }
//        } catch (NotFoundException e) {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }

}
