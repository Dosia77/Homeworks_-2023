package ru.gb.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    
    @GetMapping("/hello")
    public String helloPage(@RequestParam String username){

        
        return "<h1>Hello, "+ username + "!</h1>";
    }

  
}
