package com.login.service.impl;

import com.login.dao.LoginRespository;
import com.login.dao.UserRepository;
import com.login.entity.Login;
import com.login.entity.User;
import com.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LoginRespository loginRespository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findOne(Login login) {
        Optional<Login> optionalLogin = loginRespository.findByOauthTypeAndOauthId(login.getOauthType(), login.getOauthId());
        if(optionalLogin.isPresent()){
           return userRepository.findById(optionalLogin.get().getUserId());
        }else{
           throw new RuntimeException("No Login Account");
        }
    }
}
