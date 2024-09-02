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
    //we have to come back to this
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
