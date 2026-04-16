package com.tecno_comfenalco.pa.features.order.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.order.entity.mongo.OrderDocument;

public interface IMongoOrderRepository extends MongoRepository<OrderDocument, String> {
    List<OrderDocument> findByStore_Id(String storeId);

    List<OrderDocument> findByPresales_Id(String presalesId);

}
