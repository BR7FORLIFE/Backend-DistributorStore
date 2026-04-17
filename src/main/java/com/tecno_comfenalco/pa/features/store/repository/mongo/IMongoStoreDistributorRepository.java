package com.tecno_comfenalco.pa.features.store.repository.mongo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.store.entity.mongo.StoresDistributorsDocument;

public interface IMongoStoreDistributorRepository extends MongoRepository<StoresDistributorsDocument, String> {
    StoresDistributorsDocument save(StoresDistributorsDocument entity);

    Optional<StoresDistributorsDocument> findByStore_IdAndDistributor_Id(Long storeId, Long distributorId);

    List<StoresDistributorsDocument> findByStore_Id(Long storeId);

    List<StoresDistributorsDocument> findByDistributor_Id(Long distributorId);

    boolean existsByStore_IdAndDistributor_Id(Long storeId, Long distributorId);
}
