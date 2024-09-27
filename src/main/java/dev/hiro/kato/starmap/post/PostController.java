package dev.hiro.kato.starmap.post;


import dev.hiro.kato.starmap.security.SecurityUser;
import dev.hiro.kato.starmap.user.User;
import dev.hiro.kato.starmap.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Security;

@Controller
@RequestMapping("/posts")

public class PostController {

    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {this.postService = postService;
        this.userService = userService;
    }

    @GetMapping
    public String showBlogPosts(Model model){
        model.addAttribute("posts", postService.findAll());
        return "posts/blog";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post("", ""));
        return "posts/create";
    }

    @PostMapping
    public String createPost(@ModelAttribute Post post, Authentication authentication) {
        try{
            String username = authentication.getName();
            User user = userService.findByUsername(username)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid user"));
            post.setUser(user);
            postService.save(post);
        }finally{
            return "redirect:posts";
        }

    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        //need error handling if post not found
        model.addAttribute("post", post);
        return "posts/update";  // Corresponds to src/main/resources/templates/posts/edit.html
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable("id") Long id, @ModelAttribute Post post, Authentication authentication) {
        Post existingPost = postService.findById(id);
//                .orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        if (!existingPost.getUser().getUsername().equals(authentication.getName())) {
            return "error";
            //throw new SecurityException("You are not authorized to edit this post");

        }

        existingPost.setTitle(post.getTitle());
        existingPost.setBody(post.getBody());

        postService.save(existingPost);
        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Long id, Authentication authentication) {
        Post post = postService.findById(id);
        if (!post.getUser().getUsername().equals(authentication.getName())) {
            return "error";
            //throw new SecurityException("You are not authorized to edit this post");
        }
        postService.delete(post);
        return "redirect:/posts";
    }

}
