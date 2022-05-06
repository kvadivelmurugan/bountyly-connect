package com.bountyly.connect.resource;

import com.bountyly.connect.model.User;
import com.bountyly.connect.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping(path = "/users", produces="application/json")
    public List<User> findAllUsers () { return userService.findAllUsers(); }

    @GetMapping(path = "/users/{userId}", produces="application/json")
    public User findUserByUserId (@PathVariable String userId) { return userService.findUserByUserId(userId); }

    @PostMapping (path = "/users", produces="application/json")
    public User createUser (@RequestBody User user) { return userService.createUser (user); }

    @PutMapping (path = "/users", produces="application/json")
    public void updateUser (@RequestBody User user) { userService.updateUser (user); }

    @DeleteMapping (path = "/users", produces="application/json")
    public void deleteUser (@RequestBody User user) {
        userService.deleteUser (user);
    }
}
