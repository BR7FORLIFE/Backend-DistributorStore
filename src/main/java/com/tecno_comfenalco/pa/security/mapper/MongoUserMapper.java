package com.tecno_comfenalco.pa.security.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.security.entity.mongo.UserDocument;
import com.tecno_comfenalco.pa.security.model.UserModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoUserMapper implements EntityMapper<UserModel, UserDocument> {

    @Override
    public UserModel toDto(UserDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public UserDocument toEntity(UserModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<UserModel> toDto(List<UserDocument> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<UserDocument> toEntity(List<UserModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<UserModel> toDto(Set<UserDocument> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<UserDocument> toEntity(Set<UserModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(UserModel dto, UserDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
