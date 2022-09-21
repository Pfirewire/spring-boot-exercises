package com.codeup.springbootexercises.controllers;

import com.codeup.springbootexercises.models.Post;
import com.codeup.springbootexercises.models.User;
import com.codeup.springbootexercises.repositories.PostRepository;
import com.codeup.springbootexercises.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class UserController {
    private UserRepository userDao;
    private PostRepository postDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PostRepository postDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        System.out.println("Inside showSignupForm");
        model.addAttribute("user", new User());
        return "users/signup";
    }

    @PostMapping("/signup")
    public String saveUser(@ModelAttribute User user, @RequestParam(value = "confirmPassword") String confirmPassword) {
        String hash = passwordEncoder.encode(user.getPassword());
        if(passwordEncoder.matches(confirmPassword, hash)) {
            user.setPassword(hash);
            userDao.save(user);
            return "redirect:/login";
        } else {
            return "users/signup";
        }
    }

    @GetMapping("/profile")
    public String showUserPosts(Model model) {
        List<Post> allPosts = postDao.findAll();
        List<Post> userPosts = new ArrayList<>();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        for(Post post : allPosts) {
            if(Objects.equals(post.getUserId(), user.getId())) {
                userPosts.add(post);
            }
        }
        model.addAttribute("posts", userPosts);
        return "/users/profile";
    }
}
