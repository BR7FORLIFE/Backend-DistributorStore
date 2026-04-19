package com.tecno_comfenalco.pa.features.catalog.repository.mongo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.tecno_comfenalco.pa.features.catalog.entity.mongo.CatalogDocument;

public interface IMongoCatalogRepository extends MongoRepository<CatalogDocument, String> {
    @Query("SELECT c FROM CatalogDocument c WHERE c.distributor.id = :distributorId")
    Optional<CatalogDocument> findByDistributorId(@Param("distributorId") String distributorId);

}
