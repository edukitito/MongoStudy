package com.springwithmongo.mongostudy.resources;

import com.springwithmongo.mongostudy.domain.Post;
import com.springwithmongo.mongostudy.resources.util.URL;
import com.springwithmongo.mongostudy.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;
    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        List<Post> posts = postService.findAll();
        return ResponseEntity.ok().body(posts);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }
}
