package com.codeup.springbootexercises;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostsController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndex() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable int id) {
        return "returns individual post for id " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostGet() {
        return "view the form for creating post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPostPost() {
        return "creates a new post";
    }
}
