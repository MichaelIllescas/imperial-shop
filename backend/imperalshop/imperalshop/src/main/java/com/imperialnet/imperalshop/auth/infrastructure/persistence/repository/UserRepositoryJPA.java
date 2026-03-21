package com.imperialnet.imperalshop.auth.infrastructure.persistence.repository;

import com.imperialnet.imperalshop.auth.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJPA extends JpaRepository<UserEntity, Long> {

     Optional<UserEntity> findByEmail(String email);

}
