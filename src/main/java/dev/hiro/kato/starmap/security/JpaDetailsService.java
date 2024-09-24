package dev.hiro.kato.starmap.security;

import dev.hiro.kato.starmap.user.User;
import dev.hiro.kato.starmap.user.UserRepository;
import dev.hiro.kato.starmap.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;


@Service
public class JpaDetailsService implements UserDetailsService {

    private UserService userService;

    JpaDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        return userService
                .findByUsername(userName)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
    }
}

//what do we return -> userDetails (the last thing is calling the new method)
//lambda -> .method(SecurityUser::new)
//how do we start this functional chain off? userService -> the results it yeilds
//    User user = userService.findByUsername(username);
//        if (user == null) {
//        throw new UsernameNotFoundException(username);
//    }
//        return new SecurityUser(user);