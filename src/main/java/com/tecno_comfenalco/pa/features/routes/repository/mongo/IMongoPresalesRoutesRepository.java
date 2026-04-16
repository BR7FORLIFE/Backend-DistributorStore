package com.tecno_comfenalco.pa.features.routes.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.routes.presales.entity.mongo.PresalesRoutesDocument;

public interface IMongoPresalesRoutesRepository
                extends MongoRepository<PresalesRoutesDocument, String> {

}
