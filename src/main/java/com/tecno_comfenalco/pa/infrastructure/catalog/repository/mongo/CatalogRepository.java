package com.tecno_comfenalco.pa.infrastructure.catalog.repository.mongo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tecno_comfenalco.pa.infrastructure.catalog.entity.CatalogDocument;

public interface CatalogRepository extends MongoRepository<CatalogDocument, UUID> {
    boolean existsByIdAndCatalogCode(UUID distributorId, String catalogCode);

    @Query(value = "{ '_id':?0, 'categories.name':?1 }, exists=true")
    boolean existsCategoryNameInCatalog(UUID catalogId, String categoryName);
}
