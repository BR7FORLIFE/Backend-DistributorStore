package com.tecno_comfenalco.pa.infrastructure.catalog.repository.mongo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.infrastructure.catalog.entity.CatalogDocument;

public interface CatalogRepository extends MongoRepository<CatalogDocument, UUID> {
    boolean existsByDistributorIdAndCatalogCode(UUID distributorId, String catalogCode);

    boolean existsByIdAndCategoriesName(UUID catalogId, String name);

    boolean existsByIdAndCategoriesId(UUID Id, UUID categoryId);

    boolean existsByIdAndCategoriesIdAndCategoriesProductsId(UUID catalogId, UUID categoryId, UUID productId);

    boolean existsByIdAndDistributorId(UUID Id, UUID DistributorId);

    boolean existsById(UUID Id);
}
