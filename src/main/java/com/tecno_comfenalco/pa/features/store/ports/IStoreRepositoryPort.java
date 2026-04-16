package com.tecno_comfenalco.pa.features.store.ports;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.features.store.models.StoreModel;

public interface IStoreRepositoryPort {
    StoreModel save(StoreModel StoreModel);

    Optional<StoreModel> findById(Long id);

    Optional<StoreModel> findByNIT(Long NIT);

    Optional<StoreModel> findByUser_Id(Long userId);

    List<StoreModel> findAll();

    boolean existsByNIT(Long NIT);

    boolean existsById(Long id);

    void deleteById(Long id);
}
