package com.upgrad.ControllerDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/demo","/home"})
public class DemoController {

    @RequestMapping(value = {"/sayHello","/sayHi"},method = RequestMethod.GET) //URI -> /demo/sayHello same as : @GetMapping(value = "/sayHello")
    public @ResponseBody String sayHello(){
        //@ResponseBody converts the response into response object
        System.out.println("sayHello() is called inside DemoController class.");
        return "Hello!";
    }

    @GetMapping(value = {"/sayBye","/bye"}) //URI -> /demo/sayBye
    public @ResponseBody String sayBye(){
        //@ResponseBody converts the response into response object
        System.out.println("sayBye() is called inside DemoController class.");
        return "Bye!";
    }
}
