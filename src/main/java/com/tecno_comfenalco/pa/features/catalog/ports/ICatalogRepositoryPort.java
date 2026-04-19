package com.tecno_comfenalco.pa.features.catalog.ports;

import java.util.Optional;

import com.tecno_comfenalco.pa.features.catalog.models.CatalogModel;

public interface ICatalogRepositoryPort {
    CatalogModel save(CatalogModel catalogModel);

    Optional<CatalogModel> findById(String id);

    Optional<CatalogModel> findByDistributor_Id(String distributorId);
}
