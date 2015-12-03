package pl.java.scalatech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Profile("ldap")
public class LdapSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder
            .ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups")
                .contextSource()
                    .ldif("classpath:test-server.ldif");
    }
}