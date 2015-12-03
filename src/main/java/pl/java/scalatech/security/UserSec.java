package pl.java.scalatech.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserSec implements UserDetails{

    private static final long serialVersionUID = 1L;
    private UserDetails userDetails;

    public UserSec() {
    }

    public UserSec(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userDetails.getAuthorities();
    }

    @Override
    public String getPassword() {
        return userDetails.getPassword();
    }

    @Override
    public String getUsername() {
        return userDetails.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userDetails.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userDetails.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userDetails.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

}
