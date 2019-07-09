package com.login.dao;

import com.login.entity.Login;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LoginRespository extends JpaRepository<Login,Long> {

    Optional<Login> findByOauthTypeAndOauthId(String oauthType, String oauthId);
}
