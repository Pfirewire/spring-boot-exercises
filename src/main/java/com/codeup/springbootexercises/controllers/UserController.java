package com.codeup.springbootexercises.controllers;

import com.codeup.springbootexercises.models.User;
import com.codeup.springbootexercises.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
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
}
