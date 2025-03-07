package com.example.simulation.users.repository;

import com.example.simulation.users.domain.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUsersRepository extends JpaRepository<UsersEntity, Long> {
    Optional<UsersEntity> findByUserId(String userId);
}
