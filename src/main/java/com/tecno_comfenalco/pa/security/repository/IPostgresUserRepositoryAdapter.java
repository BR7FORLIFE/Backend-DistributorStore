package com.tecno_comfenalco.pa.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.security.entity.postgres.UserEntity;
import com.tecno_comfenalco.pa.security.mapper.PostgresUserMapper;
import com.tecno_comfenalco.pa.security.model.UserModel;
import com.tecno_comfenalco.pa.security.port.IUserRepositoryPort;
import com.tecno_comfenalco.pa.security.repository.postgres.IPostgresUserRepository;

@Profile("postgres")
@Repository
public class IPostgresUserRepositoryAdapter implements IUserRepositoryPort {

    private final IPostgresUserRepository repository;
    private final PostgresUserMapper mapper;

    public IPostgresUserRepositoryAdapter(IPostgresUserRepository repository,
            PostgresUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<UserModel> findByUsername(String username) {
        Optional<UserEntity> entityOpt = repository.findByUsername(username);
        return entityOpt.map(mapper::toDto);
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        Optional<UserEntity> entityOpt = repository.findById(id);
        return entityOpt.map(mapper::toDto);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public List<UserModel> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public UserModel save(UserModel user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

}
