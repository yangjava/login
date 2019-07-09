package com.login.service.impl;

import com.login.dao.LoginRespository;
import com.login.entity.Login;
import  java.util.Optional;

import com.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRespository loginRespository;

    @Override
    public Optional<Login> register(Login login){
        Optional<Login> loginOption = loginRespository.findByOauthTypeAndOauthId(login.getOauthType(), login.getOauthId());
        if(loginOption.isPresent()){
           throw new RuntimeException("User Exit");
        }else{
            return Optional.of(loginRespository.save(login));
        }
    }
}
