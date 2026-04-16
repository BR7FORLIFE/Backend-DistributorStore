package com.tecno_comfenalco.pa.features.store.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.store.entity.mongo.StoreDocument;

public interface IMongoStoreRepository extends MongoRepository<StoreDocument, String> {

}
