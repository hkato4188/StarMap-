package dev.hiro.kato.starmap;

import dev.hiro.kato.starmap.post.Post;
import dev.hiro.kato.starmap.post.PostRepository;
import dev.hiro.kato.starmap.post.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PostTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Post> posts = new ArrayList<>();
        posts.add(new Post());
        posts.add(new Post());
        when(postRepository.findAll()).thenReturn(posts);

        // Act
        List<Post> result = postService.findAll();

        // Assert
        assertEquals(2, result.size());
        verify(postRepository, times(1)).findAll();
    }

    @Test
    public void testSave() {
        // Arrange
        Post post = new Post();
        when(postRepository.save(any(Post.class))).thenReturn(post);

        // Act
        Post result = postService.save(post);

        // Assert
        assertEquals(post, result);
        verify(postRepository, times(1)).save(post);
    }

    @Test
    public void testFindById() {
        // Arrange
        Long id = 1L;
        Post post = new Post();
        when(postRepository.findById(id)).thenReturn(Optional.of(post));

        // Act
        Post result = postService.findById(id);

        // Assert
        assertEquals(post, result);
        verify(postRepository, times(1)).findById(id);
    }

    @Test
    public void testDelete() {
        // Arrange
        Post post = new Post();
        doNothing().when(postRepository).delete(post);

        // Act
        postService.delete(post);

        // Assert
        verify(postRepository, times(1)).delete(post);
    }
}