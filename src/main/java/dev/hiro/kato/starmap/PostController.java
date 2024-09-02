package dev.hiro.kato.starmap;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "posts/create";  // This corresponds to src/main/resources/templates/posts/create.html
    }

    @PostMapping
    public String createPost(@ModelAttribute Post post) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((SecurityUser) authentication.getPrincipal()).getUsername();
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user"));

        post.setUser(user); // Associate the post with the logged-in user
        postService.save(post);
        return "redirect:posts";  // Redirects to the list of posts after saving
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
               //need error handling if post not found
        model.addAttribute("post", post);
        return "posts/update";  // Corresponds to src/main/resources/templates/posts/edit.html
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable("id") Long id, @ModelAttribute Post post) {
        Post existingPost = postService.findById(id);
//                .orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((SecurityUser) authentication.getPrincipal()).getUsername();
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user"));

        if (!existingPost.getUser().getUsername().equals(user.getUsername())) {
            return "error";
            //throw new SecurityException("You are not authorized to edit this post");

        }

        existingPost.setTitle(post.getTitle());
        existingPost.setBody(post.getBody());

        postService.save(existingPost);
        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        Post post = postService.findById(id);
//                .orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));

        postService.delete(post);
        return "redirect:/posts";
    }

}
