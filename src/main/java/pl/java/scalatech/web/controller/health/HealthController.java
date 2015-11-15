package pl.java.scalatech.web.controller.health;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @RequestMapping("/healthTest")
    public String ping() {
        return "ok";
    }

}
