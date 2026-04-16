package com.tecno_comfenalco.pa.features.catalog.repository.mongo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.catalog.entity.mongo.CatalogDocument;

public interface IMongoCatalogRepository extends MongoRepository<CatalogDocument, String> {
    Optional<CatalogDocument> findByDistributor_Id(String distributorId);

}
