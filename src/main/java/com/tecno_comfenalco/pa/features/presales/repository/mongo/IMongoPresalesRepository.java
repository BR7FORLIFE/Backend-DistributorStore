package com.tecno_comfenalco.pa.features.presales.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.presales.entity.mongo.PresalesDocument;

public interface IMongoPresalesRepository extends MongoRepository<PresalesDocument, String> {

}
