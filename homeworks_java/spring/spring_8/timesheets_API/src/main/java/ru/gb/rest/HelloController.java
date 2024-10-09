package ru.gb.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController 
@Tag(name="Hello", description="Страница приветствия")
public class HelloController {

    
    @GetMapping("/hello")
    public String helloPage(@RequestParam String username){
   
        return "<h1>Hello, "+ username + "!</h1>"; //localhost:8080/hello?username=Anna
    }

  
}
