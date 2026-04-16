package com.tecno_comfenalco.pa.features.store.ports;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.features.store.models.StoreDistributorModel;

public interface IStoreDistributorPort {
    StoreDistributorModel save(StoreDistributorModel entity);

    Optional<StoreDistributorModel> findByStore_IdAndDistributor_Id(Long storeId, Long distributorId);

    List<StoreDistributorModel> findByStore_Id(Long storeId);

    List<StoreDistributorModel> findByDistributor_Id(Long distributorId);

    boolean existsByStore_IdAndDistributor_Id(Long storeId, Long distributorId);
}
