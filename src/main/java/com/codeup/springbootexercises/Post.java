package com.codeup.springbootexercises;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {


    // private variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // constructor functions
    public Post() {}
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }


    // getters and setters
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return this.title; }
    public void setTitle(String title){ this.title = title; }

    public String getBody() { return this.body; }
    public void setBody(String body) { this.body = body; }

    public User getUser() { return this.user; }
    public void setUser(User user) { this.user = user; }

    public Long getUserId() { return this.user.getId(); }


}
