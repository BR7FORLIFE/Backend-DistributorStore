package com.tecno_comfenalco.pa.infrastructure.product.repository.mongo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.infrastructure.product.entity.ProductDocument;

public interface ProductRepository extends MongoRepository<ProductDocument, UUID> {
    boolean existsByDistributorIdAndSku(UUID distributorId, String sku);

    boolean existsByIdAndDistributorId(UUID productId, UUID distributorId);

    void deleteByIdAndDistributorId(UUID productId, UUID distributorId);

    Page<ProductDocument> findByDistributorId(UUID distributorId, Pageable pageable);

    Optional<ProductDocument> findByDistributorIdAndId(UUID distributorId, UUID productId);
}
