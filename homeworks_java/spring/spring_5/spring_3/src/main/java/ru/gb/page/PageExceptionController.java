package ru.gb.page;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@ControllerAdvice(basePackageClasses = PageExceptionController.class)
public class PageExceptionController {


    @GetMapping("/home/oops")
   
    public String oopPage(){
        return "oops.html";
    }

@ExceptionHandler(NoSuchElementException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public String handleNoSuchElementException(NoSuchElementException e)
{
    return "not-found.html";

}

@ExceptionHandler(Exception.class)
    public String handleException(Exception e){

        return "redirect:home/oops";
   
}
    
}
