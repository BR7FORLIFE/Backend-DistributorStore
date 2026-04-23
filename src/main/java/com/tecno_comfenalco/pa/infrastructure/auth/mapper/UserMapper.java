package com.tecno_comfenalco.pa.infrastructure.auth.mapper;

import com.tecno_comfenalco.pa.domain.auth.models.UserModel;
import com.tecno_comfenalco.pa.infrastructure.auth.entity.UserDocument;

public class UserMapper {
    public static UserModel toDomain(UserDocument userDocument) {
        UserModel userModel = UserModel.createNew(userDocument.getId(), userDocument.getUsername(),
                userDocument.getPassword(), userDocument.getRoles(), userDocument.isEnabled());
        return userModel;
    }

    public static UserDocument toEntity(UserModel userModel) {
        UserDocument userDocument = new UserDocument();
        userDocument.setId(userModel.getId());
        userDocument.setUsername(userModel.getUsername());
        userDocument.setPassword(userModel.getPassword());
        userDocument.setRoles(userModel.getRoles());
        userDocument.setEnabled(userModel.isEnabled());

        return userDocument;
    }
}
