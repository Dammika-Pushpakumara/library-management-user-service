package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.User;
import org.example.entity.UserEntity;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

   final UserService userService;

    @GetMapping("/get-all-users")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/add-user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }

    @GetMapping("/find-by-user-name/{userName}")
    public User findByUserName(@PathVariable String userName){
        return userService.findByUserName(userName);
    }

    @GetMapping("/is-exist-user/{userName}")
    public Boolean isExistsUser(@PathVariable String userName){
       return userService.isExistsUser(userName);
    }
}


