package com.tecno_comfenalco.pa.infrastructure.auth.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.domain.auth.models.UserModel;
import com.tecno_comfenalco.pa.infrastructure.auth.entity.UserDocument;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserModel, UserDocument> {

}
