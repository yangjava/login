package com.login.service;

import com.login.entity.Login;

import java.util.Optional;

public interface LoginService {

    Optional<Login> register(Login login);

}
