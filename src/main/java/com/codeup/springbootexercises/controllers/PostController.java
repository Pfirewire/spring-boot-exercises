package com.codeup.springbootexercises.controllers;

import com.codeup.springbootexercises.models.User;
import com.codeup.springbootexercises.services.EmailService;
import com.codeup.springbootexercises.repositories.PostRepository;
import com.codeup.springbootexercises.repositories.UserRepository;
import com.codeup.springbootexercises.models.Post;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        List<Post> posts = postDao.findAll();
        System.out.println(posts);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        if(postDao.findById(id) == null) {
            return "redirect:/posts";
        }
        Post post = postDao.getById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        post.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        postDao.save(post);
        emailService.prepareAndSend(post, "Post Created", "" +
                "A new post has been successfully created" +
                "New Post:" +
                "\n\n" +
                post.getTitle() +
                "\n" +
                post.getBody());
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPostForm(@PathVariable Long id, Model model) {
        Post post = postDao.getById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post) {
        post.setUser(userDao.getById(Long.parseLong("1")));
        postDao.save(post);
        emailService.prepareAndSend(post, "Post Edited", "" +
                "Your post has been successfully edited." +
                "\n" +
                "New Post:" +
                "\n\n" +
                post.getTitle() +
                "\n" +
                post.getBody());
        return ("redirect:/posts/" + post.getId());
    }


}
