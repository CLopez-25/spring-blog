package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String allPosts(){
        return "Here are all the posts:...";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String onePost(@PathVariable long id){
        return "Here is post number: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Here is the form to create a post!";
    }
}
