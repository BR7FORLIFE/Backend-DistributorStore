package com.tecno_comfenalco.pa.security.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.security.entity.postgres.UserEntity;
import com.tecno_comfenalco.pa.security.model.UserModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring")
public interface PostgresUserMapper extends EntityMapper<UserModel, UserEntity> {

}
