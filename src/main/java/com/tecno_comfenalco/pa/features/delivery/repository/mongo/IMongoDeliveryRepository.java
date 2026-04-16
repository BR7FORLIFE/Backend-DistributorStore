package com.tecno_comfenalco.pa.features.delivery.repository.mongo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.delivery.entity.mongo.DeliveryDocument;

public interface IMongoDeliveryRepository extends MongoRepository<DeliveryDocument, String> {
    Optional<DeliveryDocument> findByName(String name);

    boolean existsByDocumentNumber(String documentNumber);
}
