package dev.hiro.kato.starmap.security;

import dev.hiro.kato.starmap.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityUser implements UserDetails {

    private final User user;

    public SecurityUser(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return null;}

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }


}
@Service
@Transactional
public class OAuth2UserService {

    private final UserRepository userRepository;

    public OAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void processOAuthPostLogin(OAuth2User oauthUser) {
        String email = oauthUser.getAttribute("email");

        User existingUser = userRepository.findByEmail(email);

        if (existingUser == null) {
            User newUser = new User();
            newUser.setId(oauthUser.getAttribute("sub"));  // Use unique ID from OAuth
            newUser.setEmail(email);
            newUser.setName(oauthUser.getAttribute("name"));

            userRepository.save(newUser);
        }
    }
}