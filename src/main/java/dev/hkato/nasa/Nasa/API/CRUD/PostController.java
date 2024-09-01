package dev.hkato.nasa.Nasa.API.CRUD;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")

public class PostController {

    private final PostService postService;
    public PostController(PostService postService) {this.postService = postService;}

    @GetMapping
    public String showBlogPosts(Model model){
        model.addAttribute("posts", postService.findAll());
        return "posts/blog";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post("", ""));
        return "posts/create";  // This corresponds to src/main/resources/templates/posts/create.html
    }

    @PostMapping
    public String createPost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:posts";  // Redirects to the list of posts after saving
    }
}
