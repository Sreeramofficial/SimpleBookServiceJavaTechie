package net.sreerammanatt.ProductApp.Controller;

import lombok.extern.slf4j.Slf4j;
import net.sreerammanatt.ProductApp.Entity.User;
import net.sreerammanatt.ProductApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
    public void saveUser(@RequestBody User user) {

        try {
            userService.saveUser(user);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("error occurred please try again");
        }

    }


}
