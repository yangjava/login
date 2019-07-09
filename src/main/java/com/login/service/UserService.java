package com.login.service;

import com.login.entity.Login;
import com.login.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findOne(Login login);
}
