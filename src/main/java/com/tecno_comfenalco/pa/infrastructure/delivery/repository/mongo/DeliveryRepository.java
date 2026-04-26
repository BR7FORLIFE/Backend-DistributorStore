package com.tecno_comfenalco.pa.infrastructure.delivery.repository.mongo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.infrastructure.delivery.entity.DeliveryDocument;

public interface DeliveryRepository extends MongoRepository<DeliveryDocument, UUID> {

    boolean existsByDocumentNumber(Long DocumentNumber);
}
