package com.codeup.springbootexercises;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        List<Post> posts = postDao.findAll();
        if(id > posts.size()) {
            model.addAttribute("posts", posts);
            return "posts/index";
        }
        Post post = postDao.getById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPostGet() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPostPost(@Param("title") String title, @Param("body") String body, Model model) {
        Post post = new Post(title, body);
        postDao.save(post);
        model.addAttribute("post", post);
        return "posts/show";
    }
}
