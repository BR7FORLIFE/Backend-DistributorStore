package com.tecno_comfenalco.pa.infrastructure.store.repository.mongo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.infrastructure.store.entity.StoreDocument;

public interface StoreRepository extends MongoRepository<StoreDocument, UUID> {
    boolean existsByNit(String Nit);

    
}
