package com.blog.controller;

import com.blog.model.Post;
import com.blog.model.Status;
import com.blog.payload.PostDTO;
import com.blog.payload.request.PostStatusUpdateRequest;
import com.blog.service.AuthorService;
import com.blog.service.PostService;
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
            if (post.getStatus() == Status.PUBLISHED) {
                Long authorId = null;
                if (post.getAuthor() != null) {
                    authorId = post.getAuthor().getId();
                }
                PostDTO postDTO = new PostDTO(
                        post.getId(),
                        post.getTitle(),
                        post.getImage(),
                        post.getContent(),
                        authorId,
                        post.getCreated_at(),
                        post.getUpdated_at(),
                        post.getCategory(),
                        post.getStatus());
                postDTOs.add(postDTO);
            }
        }
        return postDTOs;
    }

    @GetMapping("/pending")
    public List<PostDTO> getAllPendingPosts() {
        List<Post> posts = service.getAll();
        List<PostDTO> postDTOs = new ArrayList<>();
        for (Post post : posts) {
            if (post.getStatus() == Status.PENDING) {
                Long authorId = null;
                if (post.getAuthor() != null) {
                    authorId = post.getAuthor().getId();
                }
                PostDTO postDTO = new PostDTO(
                        post.getId(),
                        post.getTitle(),
                        post.getImage(),
                        post.getContent(),
                        authorId,
                        post.getCreated_at(),
                        post.getUpdated_at(),
                        post.getCategory(),
                        post.getStatus());
                postDTOs.add(postDTO);
            }
        }
        return postDTOs;
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<PostDTO> updatePostStatus(@PathVariable Long id) {
        Post post = service.getPost(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        service.publishPost(post.getId());
        PostDTO postDTO = new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getImage(),
                post.getContent(),
                post.getAuthor().getId(),
                post.getCreated_at(),
                post.getUpdated_at(),
                post.getCategory(),
                post.getStatus());
        return ResponseEntity.ok(postDTO);
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

    @GetMapping("/author/{id}")
    public List<PostDTO> getPostsByAuthorId(@PathVariable Long id) {
        List<Post> posts = service.getRecipesByAuthorId(id);
        List<PostDTO> postDTOs = new ArrayList<>();
        for (Post post : posts) {
            PostDTO postDTO = new PostDTO(
                    post.getId(),
                    post.getTitle(),
                    post.getImage(),
                    post.getContent(),
                    post.getAuthor().getId(),
                    post.getCreated_at(),
                    post.getUpdated_at(),
                    post.getCategory(),
                    post.getStatus());
            postDTOs.add(postDTO);
        }
        return postDTOs;
    }

    @GetMapping("/random")
    public ResponseEntity<?> getThreeRandomRecipes() {
        try {
            List<Post> posts = service.getThreeRandomPosts();

            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch recipes.");
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
