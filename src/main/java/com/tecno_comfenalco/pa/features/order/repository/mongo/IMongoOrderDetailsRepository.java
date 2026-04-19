package com.tecno_comfenalco.pa.features.order.repository.mongo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.order.entity.mongo.OrderDetailDocument;

public interface IMongoOrderDetailsRepository extends MongoRepository<OrderDetailDocument, String> {
    Optional<OrderDetailDocument> findByid(String id);

    OrderDetailDocument save(OrderDetailDocument OrderDocument);

    boolean existsByid(String id);

    void deleteByid(String id);
}
