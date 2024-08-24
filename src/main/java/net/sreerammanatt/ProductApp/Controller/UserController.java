package net.sreerammanatt.ProductApp.Controller;

import lombok.extern.slf4j.Slf4j;
import net.sreerammanatt.ProductApp.Entity.User;
import net.sreerammanatt.ProductApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUserDetails/{userId}")
    public User getUserDetails(@PathVariable Long userId) {
        return userService.getUserById(userId);

    }

    @PostMapping("/saveUser")

    public String saveUser(@RequestBody  @Valid User user) {


        return userService.saveUser(user);


    }
}