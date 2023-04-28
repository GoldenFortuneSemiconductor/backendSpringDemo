package net.nvsoftware.springdemo.controller;

import net.nvsoftware.springdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "Homepage";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User user(){
        User user = new User();
        user.setId("123");
        user.setName("nvsoftware");
        user.setEmail("info@nvsoftware");

        return user;
    }

    @GetMapping("/user/{id}/{username}")
    public User userByPathVariable(@PathVariable String id, @PathVariable("username") String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail("info@nvsoftware");

        return user;
    }

    @GetMapping("/userrequest")
    public User userByRequestParams(
            @RequestParam String id,
            @RequestParam("username") String name,
            @RequestParam(required = false, defaultValue = "") String email
            ){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);

        return user;
    }
}
