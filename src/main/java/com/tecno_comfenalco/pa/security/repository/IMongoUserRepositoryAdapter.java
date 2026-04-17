package com.tecno_comfenalco.pa.security.repository;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.security.entity.mongo.UserDocument;
import com.tecno_comfenalco.pa.security.model.UserModel;
import com.tecno_comfenalco.pa.security.port.IUserRepositoryPort;
import com.tecno_comfenalco.pa.security.repository.mongo.IMongoUserRepository;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class IMongoUserRepositoryAdapter implements IUserRepositoryPort {

    private final IMongoUserRepository repository;
    private final EntityMapper<UserModel, UserDocument> mapper;

    public IMongoUserRepositoryAdapter(IMongoUserRepository repository, EntityMapper<UserModel, UserDocument> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<UserModel> findByUsername(String username) {
        Optional<UserDocument> entityOpt = repository.findByUsername(username);
        return entityOpt.map(mapper::toDto);
        // throw new UnsupportedOperationException("Unimplemented method
        // 'findByUsername'");
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        Optional<UserDocument> entityOpt = repository.findById(id);
        return entityOpt.map(mapper::toDto);
        // throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
        // throw new UnsupportedOperationException("Unimplemented method
        // 'existsByUsername'");
    }

    @Override
    public List<UserModel> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
        // throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public UserModel save(UserModel user) {
        UserDocument entity = mapper.toEntity(user);
        UserDocument savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
        // throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
