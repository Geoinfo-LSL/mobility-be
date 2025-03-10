package com.example.simulation.users.repository;

import com.example.simulation.users.domain.UsersEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUsersRepository extends JpaRepository<UsersEntity, Long> {
    Optional<UsersEntity> findByUserId(String userId);
}
