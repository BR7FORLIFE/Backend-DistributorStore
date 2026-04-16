package com.tecno_comfenalco.pa.features.routes.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.routes.deliveries.entity.mongo.DeliveryRoutesDocument;

public interface IMongoDeliveryRoutesRepository extends MongoRepository<DeliveryRoutesDocument, String>{

}
