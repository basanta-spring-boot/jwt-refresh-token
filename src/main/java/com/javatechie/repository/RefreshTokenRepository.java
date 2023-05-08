package com.javatechie.repository;

import com.javatechie.entity.RefreshToken;
import com.javatechie.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Integer> {

    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(UserInfo user);
}
