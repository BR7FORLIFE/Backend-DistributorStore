package com.tecno_comfenalco.pa.features.distributor.ports;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;

public interface IDistributorRepositoryPort {
    Optional<DistributorModel> findById(Long id);

    Optional<DistributorModel> findByName(String name);

    List<DistributorModel> findAll();

    DistributorModel save(DistributorModel DistributorModel);

    boolean existsByName(String name);

    Optional<DistributorModel> findByUser_Id(Long userId);

    Optional<DistributorModel> findByNIT(Long NIT);
}
