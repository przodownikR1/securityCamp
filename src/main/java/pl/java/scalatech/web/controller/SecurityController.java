package pl.java.scalatech.web.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.annotation.CurrentUser;
import pl.java.scalatech.domain.User;

@Controller
@Slf4j
public class SecurityController {

    @RequestMapping("/currentUser")
    public ResponseEntity<User> currentUser(@CurrentUser User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping("secContext")
    public ResponseEntity<Map<String, Object>> secContext(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        model.addAttribute("principal", authentication.getName());

        return new ResponseEntity<>(model.asMap(), HttpStatus.OK);

    }

    @RequestMapping("/principal")
    public ResponseEntity<String> principal(Principal principal) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("++++    {}", auth.getAuthorities());

        return new ResponseEntity<>(principal.getName(), HttpStatus.OK);

    }
}
