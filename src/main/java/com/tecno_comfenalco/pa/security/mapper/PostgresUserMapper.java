package com.tecno_comfenalco.pa.security.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.security.entity.postgres.UserEntity;
import com.tecno_comfenalco.pa.security.model.UserModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresUserMapper implements EntityMapper<UserModel, UserEntity>{

    @Override
    public UserModel toDto(UserEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public UserEntity toEntity(UserModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<UserModel> toDto(List<UserEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<UserEntity> toEntity(List<UserModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<UserModel> toDto(Set<UserEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<UserEntity> toEntity(Set<UserModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(UserModel dto, UserEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
