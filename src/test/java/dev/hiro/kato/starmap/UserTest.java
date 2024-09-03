package dev.hiro.kato.starmap;

import dev.hiro.kato.starmap.user.User;
import dev.hiro.kato.starmap.user.UserRepository;
import dev.hiro.kato.starmap.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        when(userRepository.findAll()).thenReturn(users);

        // Act
        List<User> result = userService.findAll();

        // Assert
        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testSave() {
        // Arrange
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        User result = userService.save(user);

        // Assert
        assertEquals(user, result);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testFindById() {
        // Arrange
        Long id = 1L;
        User user = new User();
        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        // Act
        User result = userService.findById(id);

        // Assert
        assertEquals(user, result);
        verify(userRepository, times(1)).findById(id);
    }

    @Test
    public void testDelete() {
        // Arrange
        User user = new User();
        doNothing().when(userRepository).delete(user);

        // Act
        userService.delete(user);

        // Assert
        verify(userRepository, times(1)).delete(user);
    }
}
