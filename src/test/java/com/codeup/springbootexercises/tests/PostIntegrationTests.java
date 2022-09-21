package com.codeup.springbootexercises.tests;

import com.codeup.springbootexercises.SpringBootExercisesApplication;
import com.codeup.springbootexercises.models.Post;
import com.codeup.springbootexercises.models.User;
import com.codeup.springbootexercises.repositories.PostRepository;
import com.codeup.springbootexercises.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import javax.servlet.http.HttpSession;


import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootExercisesApplication.class)
@AutoConfigureMockMvc
public class PostIntegrationTests {

    private User testUser;
    private HttpSession httpSession;

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserRepository userDao;

    @Autowired
    PostRepository postDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setup() throws Exception {

        testUser = userDao.findByUsername("testUser");

        if(testUser == null) {
            User newUser = new User();
            newUser.setUsername("testUser");
            newUser.setPassword(passwordEncoder.encode("testPassword"));
            newUser.setEmail("testEmail@codeup.com");
            testUser = userDao.save(newUser);
        }

        httpSession = this.mvc.perform(post("/login").with(csrf())
                .param("username", "testUser")
                .param("password", "testPassword"))
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(redirectedUrl("/posts"))
                .andReturn()
                .getRequest()
                .getSession();
    }

    @Test
    public void testShowPost() throws Exception {
        Post existingPost = postDao.findAll().get(0);

        this.mvc.perform(get("/posts/" + existingPost.getId()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(existingPost.getBody())))
        ;
    }

    @Test
    public void testPostIndex() throws Exception {
        Post existingPost = postDao.findAll().get(0);
        Post secondExistingPost = postDao.findAll().get(1);

        this.mvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(existingPost.getTitle())))
                .andExpect(content().string(containsString(secondExistingPost.getTitle())))
        ;
    }

    @Test
    public void testCreatePost() throws Exception {
        this.mvc.perform(
                post("/posts/create").with(csrf())
                        .session((MockHttpSession) httpSession)
                        .param("title", "test")
                        .param("body", "post body"))
                .andExpect(status().is3xxRedirection())
        ;
    }

    @Test
    public void testEditPost() throws Exception {
        Post existingPost = postDao.findAll().get(0);

        this.mvc.perform(
                post("/posts/" + existingPost.getId() + "/edit").with(csrf())
                        .session((MockHttpSession) httpSession)
                        .param("title", "edited title")
                        .param("body", "edited body"))
                .andExpect(status().is3xxRedirection())
        ;

        this.mvc.perform(get("/posts/" + existingPost.getId()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("edited title")))
                .andExpect(content().string(containsString("edited body")))
        ;


    }
}
