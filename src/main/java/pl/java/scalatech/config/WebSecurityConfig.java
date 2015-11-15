package pl.java.scalatech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebMvcSecurity
@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AccessDeniedHandlerImpl deniedhandler = new AccessDeniedHandlerImpl();
        deniedhandler.setErrorPage("/accessdenied");
        http
           .authorizeRequests().antMatchers("/welcome","/login","/healthTest","/api/ping", "/signup", "/about","/register","/currentUser").permitAll()
          .antMatchers("/api/admin/**").hasRole("ADMIN")
          .antMatchers("/api/appContext").hasRole("ADMIN")
          .antMatchers("/metrics/**").hasAuthority("ADMIN")
          .antMatchers("/health/**").hasAuthority("ADMIN")
          .antMatchers("/trace/**").hasAuthority("ADMIN")
          .antMatchers("/dump/**").hasAuthority("ADMIN")
          .antMatchers("/shutdown/**").hasAuthority("ADMIN")
          .antMatchers("/beans/**").hasAuthority("ADMIN")
          .antMatchers("/info/**").hasAuthority("ADMIN")
          .antMatchers("/autoconfig/**").hasAuthority("ADMIN")
          .antMatchers("/env/**").hasAuthority("ADMIN")
          .antMatchers("/trace/**").hasAuthority("ADMIN")
          .antMatchers("/api/user/**").hasRole("USER")
          .antMatchers("/currentUser").hasRole("USER")
          .antMatchers("/sampleAdmin/**").hasAuthority("ADMIN")
          .antMatchers("/sampleUser").hasAuthority("USER")
          .antMatchers("/logout").authenticated()
          .antMatchers("/api/business**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_BUSINESS')")
          .anyRequest().authenticated();




        http
        .formLogin()
        .loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/login")
        .permitAll()
        .and()
        .logout().logoutUrl("/logout").logoutSuccessUrl("/welcome").invalidateHttpSession(true).deleteCookies("JSESSIONID")
         .permitAll().and().exceptionHandling()
         .accessDeniedHandler(deniedhandler)
         .and();





    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**").antMatchers("/css/**").antMatchers("/js/**").antMatchers("/images/**").antMatchers("/favicon.ico");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        log.info("+++++   inMemoryAuth");
        auth.inMemoryAuthentication().withUser("user").password("slawek").roles("USER").and().withUser("bolek").password("slawek").roles("BUSINESS").and()
                .withUser("admin").password("slawek").roles("USER", "ADMIN");

    }

}