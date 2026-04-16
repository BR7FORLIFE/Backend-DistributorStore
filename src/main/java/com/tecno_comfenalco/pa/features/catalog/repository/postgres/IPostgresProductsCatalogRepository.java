package com.tecno_comfenalco.pa.features.catalog.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.features.catalog.entity.postgres.ProductsCatalogEntity;

public interface IPostgresProductsCatalogRepository extends JpaRepository<ProductsCatalogEntity, Long> {

}
