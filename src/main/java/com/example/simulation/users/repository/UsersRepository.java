package com.example.simulation.users.repository;

import com.example.simulation.users.domain.UsersEntity;
import java.util.Optional;

public interface UsersRepository {
    UsersEntity save(UsersEntity MemberEntity);

    Optional<UsersEntity> findByUserId(String userId);

    Optional<UsersEntity> findById(Long id);
}
