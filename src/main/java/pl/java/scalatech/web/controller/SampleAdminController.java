package pl.java.scalatech.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sampleAdmin")
@Slf4j
public class SampleAdminController {

    public String hello() {
        return "sampleAdmin";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logged")
    @ResponseBody
    public String createMovie() {
    UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().
    getPrincipal();
    return "User "+ user.getUsername();
    }
}