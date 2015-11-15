package pl.java.scalatech.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController

@Slf4j
public class SampleUserController {
    @RequestMapping("/sampleUser")
    public String hello() {
        return "sampleUser";
    }
}