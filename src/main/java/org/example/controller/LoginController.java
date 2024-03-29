package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.Login;

import org.example.service.LoginService;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    final LoginService loginService;
    @PostMapping("/request-login")
    public Boolean validateLogin(@RequestBody Login login){
        log.info(login.toString());
       return loginService.validateLogin(login);

    }
}
