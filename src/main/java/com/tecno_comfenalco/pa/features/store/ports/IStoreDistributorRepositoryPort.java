package com.tecno_comfenalco.pa.features.store.ports;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.features.store.models.StoreDistributorModel;

public interface IStoreDistributorRepositoryPort {
    StoreDistributorModel save(StoreDistributorModel entity);

    Optional<StoreDistributorModel> findByStore_IdAndDistributor_Id(String storeId, String distributorId);

    List<StoreDistributorModel> findByStore_Id(String storeId);

    List<StoreDistributorModel> findByDistributor_Id(String distributorId);

    boolean existsByStore_IdAndDistributor_Id(String storeId, String distributorId);
}
