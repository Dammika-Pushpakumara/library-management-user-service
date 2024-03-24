package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.User;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

   final UserRepository userRepository;

    final ModelMapper mapper;
    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }



    @Override
    public void addUser(User user) {
        UserEntity entity = mapper.map(user, UserEntity.class);
        userRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUserName(String userName) {
        return mapper.map(userRepository.findByUserName(userName), User.class);
    }

    @Override
    public Boolean isExistsUser(String userName) {
       return userRepository.existsByUserName(userName);
    }
}
