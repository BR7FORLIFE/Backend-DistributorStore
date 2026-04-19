package com.tecno_comfenalco.pa.security.repository.postgres;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.security.entity.postgres.UserEntity;

public interface IPostgresUserRepository extends JpaRepository<UserEntity, String> {
    Boolean existsByUsername(String username);

    Optional<UserEntity> findByUsername(String username);
}
