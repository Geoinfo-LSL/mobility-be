package com.example.mobility.users.repository;

import com.example.mobility.users.domain.UsersEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUsersRepository extends JpaRepository<UsersEntity, Long> {
    Optional<UsersEntity> findByUserId(String userId);
}
