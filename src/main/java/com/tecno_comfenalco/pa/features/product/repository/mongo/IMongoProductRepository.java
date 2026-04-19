package com.tecno_comfenalco.pa.features.product.repository.mongo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.product.entity.mongo.ProductDocument;

public interface IMongoProductRepository extends MongoRepository<ProductDocument, String> {
    Optional<ProductDocument> findById(String id);

    Optional<ProductDocument> findByName(String name);

    List<ProductDocument> findAll();

    boolean existsByName(String name);

    List<ProductDocument>findByDistributor_Id(String id);

}
