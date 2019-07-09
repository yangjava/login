package com.login.controller;

import com.login.entity.Login;
import com.login.entity.User;
import com.login.service.LoginService;
import com.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Login> register(Login login) {
        Optional<Login> loginOptional = loginService.register(login);
        if(loginOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(loginOptional.get());
        }else{
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/find")
    @ResponseBody
    public ResponseEntity<User> find(Login login) {
        Optional<User> userOptional = userService.findOne(login);
        if(userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }




}
