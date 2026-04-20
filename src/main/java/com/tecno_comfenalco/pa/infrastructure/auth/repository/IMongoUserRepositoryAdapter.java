package com.tecno_comfenalco.pa.infrastructure.auth.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.application.auth.ports.IUserRepositoryPort;
import com.tecno_comfenalco.pa.domain.auth.models.UserModel;
import com.tecno_comfenalco.pa.infrastructure.auth.entity.UserDocument;
import com.tecno_comfenalco.pa.infrastructure.auth.mapper.UserMapper;
import com.tecno_comfenalco.pa.infrastructure.auth.repository.mongo.IMongoUserRepository;

@Repository
public class IMongoUserRepositoryAdapter implements IUserRepositoryPort {
    private final IMongoUserRepository iMongoUserRepository;
    private final UserMapper userMapper;

    public IMongoUserRepositoryAdapter(IMongoUserRepository iMongoUserRepository, UserMapper userMapper) {
        this.iMongoUserRepository = iMongoUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean existsByUsername(String username) {
        return iMongoUserRepository.existsByUsername(username);
    }

    @Override
    public UserModel save(UserModel userModel) {
        UserDocument userDocument = userMapper.toEntity(userModel);
        UserDocument saved = iMongoUserRepository.save(userDocument);

        return userMapper.toDto(saved);
    }

    @Override
    public Optional<UserModel> findByUserId(UUID id) {
        return iMongoUserRepository.findById(id)
                .map(userMapper::toDto);
    }

    @Override
    public List<UserModel> findAll() {
        return iMongoUserRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public Optional<UserModel> findByUsername(String username) {
        return iMongoUserRepository.findByUsername(username).map(userMapper::toDto);
    }
}
