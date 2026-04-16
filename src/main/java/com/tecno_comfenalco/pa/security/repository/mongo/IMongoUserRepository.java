package com.tecno_comfenalco.pa.security.repository.mongo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.security.entity.mongo.UserDocument;

public interface IMongoUserRepository extends MongoRepository<UserDocument, String> {
    Optional<UserDocument> findByUsername(String username);

    Optional<UserDocument> findById(Long id);

    boolean existsByUsername(String username);

    List<UserDocument> findAll();

    UserDocument save(UserDocument user);
}
