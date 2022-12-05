package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postDao;
    private final UserRepository usersDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository usersDao, EmailService emailService){
        this.postDao = postDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
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
    public String createPost(Model model){
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/create")
    public String submitPost(@ModelAttribute Post post){
        long currentUserId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        if (currentUserId == 0){
            return "redirect:/login";
        }
        User user = usersDao.findById(currentUserId);
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(user, post.getTitle(), post.getBody());
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showEditPostForm(@PathVariable long id, Model model){
        long currentUserId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        if (currentUserId == 0){
            return "redirect:/login";
        }
        Post post = postDao.findById(id);
        if (post.getUser().getId() != currentUserId){
            return "redirect:/posts";
        }
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@ModelAttribute Post post){
        long currentUserId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        if (currentUserId == 0){
            return "redirect:/login";
        }
        User user = usersDao.findById(currentUserId);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable long id){
        Post post = postDao.findById(id);
        postDao.delete(post);
        return "redirect:/posts";
    }

}