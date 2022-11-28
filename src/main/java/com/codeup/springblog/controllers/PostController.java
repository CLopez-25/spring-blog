package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postDao;
    private final UserRepository usersDao;

    public PostController(PostRepository postDao, UserRepository usersDao){
        this.postDao = postDao;
        this.usersDao = usersDao;
    }

    @GetMapping
    public String allPosts(Model model){
        List<Post> allPosts = postDao.findAll();
        model.addAttribute("allPosts", allPosts);
        return "/posts/index";
    }

    @GetMapping("/{id}")
    public String onePost(@PathVariable long id, Model model){
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/create")
    public String createPost(){
        return "/posts/create";
    }

    @PostMapping("/create")
    public String submitPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        User user = usersDao.findById(2L);
        Post post = new Post(title, body, user);
        postDao.save(post);
        return "redirect:/posts";
    }
}