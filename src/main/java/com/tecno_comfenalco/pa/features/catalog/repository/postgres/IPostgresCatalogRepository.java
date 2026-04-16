package com.tecno_comfenalco.pa.features.catalog.repository.postgres;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.features.catalog.entity.postgres.CatalogEntity;

public interface IPostgresCatalogRepository extends JpaRepository<CatalogEntity, Long> {
    CatalogEntity save(CatalogEntity catalogEntity);

    Optional<CatalogEntity> findById(Long id);

    Optional<CatalogEntity> findByDistributor_Id(Long distributorId);
}
