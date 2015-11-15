package pl.java.scalatech.main;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BackendTest {
    private final String name = "slawek";
    private final String password = "borowiec";
    AuthenticationManager am = new SampleAuthenticationManager();

    @Test
    public void shouldAuthentication() {
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(name, password);
            Authentication result = am.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);

        } catch (AuthenticationException e) {
            log.error("Authentication failed: {}", e.getMessage());
        } finally {
        }
        log.info("Successfully authenticated. Security context contains: {}", SecurityContextHolder.getContext().getAuthentication());
    }

}

class SampleAuthenticationManager implements AuthenticationManager {
    static final List<GrantedAuthority> AUTHORITIES = Lists.newArrayList();

    static {
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {

        if (auth.getName()
                .equals(auth.getCredentials())) { return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), AUTHORITIES); }
        throw new BadCredentialsException("Bad Credentials");

    }

}
