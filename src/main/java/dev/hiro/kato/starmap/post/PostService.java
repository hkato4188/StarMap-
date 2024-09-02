package dev.hiro.kato.starmap.post;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostService {
    private PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    };

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Post findById(Long id) {return postRepository.findById(id).get();}

    public void delete(Post post) {postRepository.delete(post);}
}
