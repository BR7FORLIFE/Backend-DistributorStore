package com.tecno_comfenalco.pa.features.catalog.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.catalog.entity.mongo.ProductsCatalogDocument;

public interface IMongoProductsCatalogRepository extends MongoRepository<ProductsCatalogDocument, String> {

}
