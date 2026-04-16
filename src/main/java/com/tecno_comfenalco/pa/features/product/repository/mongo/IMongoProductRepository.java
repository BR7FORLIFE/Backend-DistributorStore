package com.tecno_comfenalco.pa.features.product.repository.mongo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.product.entity.mongo.ProductDocument;

public interface IMongoProductRepository extends MongoRepository<ProductDocument, String> {
    ProductDocument save(ProductDocument ProductDocument);

    Optional<ProductDocument> findById(UUID id);

    Optional<ProductDocument> findByName(String name);

    List<ProductDocument> findAll();

    List<ProductDocument> findByCategoryProduct_Category_Id(Long id);

    boolean existsByName(String name);

    void deleteById(UUID id);
}
