package com.tecno_comfenalco.pa.features.order.repository.mongo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.order.entity.mongo.OrderDetailDocument;
import com.tecno_comfenalco.pa.features.order.entity.mongo.OrderDocument;

public interface IMongoOrderDetailsRepository extends MongoRepository<OrderDetailDocument, String> {
    Optional<OrderDocument> findByid(UUID id);

    OrderDocument save(OrderDocument OrderDocument);

    List<OrderDocument> findByStore_Id(Long storeId);

    List<OrderDocument> findByPresales_Id(Long presalesId);

    boolean existsByid(UUID id);

    void deleteById(UUID id);
}
