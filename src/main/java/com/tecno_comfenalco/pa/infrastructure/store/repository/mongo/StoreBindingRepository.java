package com.tecno_comfenalco.pa.infrastructure.store.repository.mongo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.infrastructure.store.entity.StoreBindingRequestDocument;

public interface StoreBindingRepository extends MongoRepository<StoreBindingRequestDocument, UUID> {
    
}
