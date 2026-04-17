package com.tecno_comfenalco.pa.features.store.repository.mongo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.store.entity.mongo.StoreDocument;

public interface IMongoStoreRepository extends MongoRepository<StoreDocument, String> {
    StoreDocument save(StoreDocument StoreDocument);

    Optional<StoreDocument> findById(Long id);

    Optional<StoreDocument> findByNIT(Long NIT);

    Optional<StoreDocument> findByUser_Id(Long userId);

    List<StoreDocument> findAll();

    boolean existsByNIT(Long NIT);

    boolean existsById(Long id);

    void deleteById(Long id);
}
