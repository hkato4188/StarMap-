package dev.hiro.kato.starmap;

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

    Post findById(Long id) {return postRepository.findById(id).get();}

    void delete(Post post) {postRepository.delete(post);}
}
