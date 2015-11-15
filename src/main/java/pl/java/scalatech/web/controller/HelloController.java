package pl.java.scalatech.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloController {
    @RequestMapping("/home")
    String hello(){
        log.info("+++ hello ..");
        return "hello";
    }
}
