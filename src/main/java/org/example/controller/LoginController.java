package org.example.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.example.dto.Login;

import org.example.service.LoginService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    final LoginService loginService;
    @PostMapping("/request-login")
    public Boolean validateLogin(@RequestBody Login login){
       return loginService.validateLogin(login);

    }
}
