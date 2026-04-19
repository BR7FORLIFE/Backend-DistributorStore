package com.tecno_comfenalco.pa.security.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.security.entity.mongo.UserDocument;
import com.tecno_comfenalco.pa.security.model.UserModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring")
public interface MongoUserMapper extends EntityMapper<UserModel, UserDocument> {

}
