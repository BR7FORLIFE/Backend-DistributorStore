package com.tecno_comfenalco.pa.application.distributor.ports;

import java.util.Optional;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.distributor.model.DistributorModel;
import com.tecno_comfenalco.pa.shared.utils.http.PagedResult;

public interface IDistributorRepositoryPort {

    boolean existsDistributorById(UUID distributorId);

    boolean existsDistributorByNit(String nit);

    boolean existsDistributorByEmail(String email);

    DistributorModel save(DistributorModel distributorModel);

    PagedResult<DistributorModel> findAllPaged(String name, Integer page, Integer size, String sortBy,
            String direction);

    Optional<DistributorModel> findByUserId(UUID userId);

    Optional<DistributorModel> findById(UUID id);

    Optional<DistributorModel> findByNIT(String NIT);
}
