package com.tecno_comfenalco.pa.features.distributor.repository.mongo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.distributor.entity.mongo.DistributorDocument;

public interface IMongoDistributorRepository extends MongoRepository<DistributorDocument, String> {
    Optional<DistributorDocument> findById(String id);

    Optional<DistributorDocument> findByName(String name);

    List<DistributorDocument> findAll();

    DistributorDocument save(DistributorDocument distributorDocument);

    boolean existsByName(String name);

    Optional<DistributorDocument> findByUser_Id(String userId);

    Optional<DistributorDocument> findByNIT(String NIT);
}
