package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.Login;
import org.example.entity.LoginEntity;
import org.example.repository.LoginRepository;
import org.example.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

    final LoginRepository loginRepository;
    final ModelMapper mapper;
    @Override
    public void insertLoginData(Login login) {
        loginRepository.save(mapper.map(login, LoginEntity.class));
    }

    @Override
    public Boolean validateLogin(Login login) {
        log.info(login.toString());

       return loginRepository.existsByEmailAndPassword(login.getEmail(),login.getPassword());
    }
}
