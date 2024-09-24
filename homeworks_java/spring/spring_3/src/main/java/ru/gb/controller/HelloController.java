package ru.gb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    
    @GetMapping("/hello")//localhost:8080/hello?username = Anna
    public String helloPage(@RequestParam String username){

        
        return "<h1>Hello, "+ username + "!</h1>";
    }

    // @GetMapping("/hello/{username}")
    // public  String helloPagePathVariable(@PathVariable String username){

    //     return "<h1>Hello, "+ username + "!</h1>";

    // }
}
