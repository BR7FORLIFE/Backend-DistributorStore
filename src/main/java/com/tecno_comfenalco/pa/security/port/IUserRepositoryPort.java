package com.tecno_comfenalco.pa.security.port;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.security.model.UserModel;

public interface IUserRepositoryPort {
    Optional<UserModel> findByUsername(String username);

    Optional<UserModel> findById(String id);

    boolean existsByUsername(String username);

    List<UserModel> findAll();

    UserModel save(UserModel user);
}
