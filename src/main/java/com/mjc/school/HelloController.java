package com.mjc.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/")
    public String getHomePage() {
        return "*** THIS IS HOME PAGE! ***";
    }

    @GetMapping(value = "/hello")
    public String greet() {
        return "Hello Page!";
    }
}
