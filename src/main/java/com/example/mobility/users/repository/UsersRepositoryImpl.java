package com.example.mobility.users.repository;

import com.example.mobility.users.domain.UsersEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UsersRepositoryImpl implements UsersRepository {

    private final JpaUsersRepository jpaUsersRepository;

    @Override
    public UsersEntity save(UsersEntity usersEntity) {
        return jpaUsersRepository.save(usersEntity);
    }

    @Override
    public Optional<UsersEntity> findByUserId(String userId) {
        return jpaUsersRepository.findByUserId(userId);
    }

    public Optional<UsersEntity> findById(Long memberId) {
        return jpaUsersRepository.findById(memberId);
    }
}
