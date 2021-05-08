package com.example.ioccontainer.Controllers;

import com.example.ioccontainer.Entities.User;
import com.example.ioccontainer.Services.IUserService;
import com.example.ioccontainer.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;

    @PostMapping(value = "")
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @DeleteMapping(value = "")
    public User deleteUser(@RequestBody User user) throws Exception {
        return service.deleteUser(user);
    }
}
