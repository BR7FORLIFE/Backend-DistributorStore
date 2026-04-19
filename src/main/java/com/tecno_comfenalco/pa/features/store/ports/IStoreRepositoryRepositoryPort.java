package com.tecno_comfenalco.pa.features.store.ports;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.features.store.models.StoreModel;

public interface IStoreRepositoryRepositoryPort {
    StoreModel save(StoreModel StoreModel);

    Optional<StoreModel> findById(String id);

    Optional<StoreModel> findByNIT(Long NIT);

    Optional<StoreModel> findByUser_Id(String userId);

    List<StoreModel> findAll();

    boolean existsByNIT(Long NIT);

    boolean existsById(String id);

    void deleteById(String id);
}
