package dev.hkato.nasa.Nasa.API.CRUD;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostService {
    private PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    List<Post> findAll(){
        return postRepository.findAll();
    };

    Post save(Post post) {
        return postRepository.save(post);
    }

}
