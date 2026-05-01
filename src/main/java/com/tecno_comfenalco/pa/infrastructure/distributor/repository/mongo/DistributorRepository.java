package com.tecno_comfenalco.pa.infrastructure.distributor.repository.mongo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.infrastructure.distributor.entity.DistributorDocument;

public interface DistributorRepository extends MongoRepository<DistributorDocument, UUID> {
    boolean existsByEmail(String Email);

    boolean existsByNit(String Nit);

    boolean existsById(UUID Id);

    Optional<DistributorDocument> findById(UUID Id);

    Optional<DistributorDocument> findByNit(String Nit);

    Page<DistributorDocument> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Optional<DistributorDocument> findByUserId(UUID UserId);
}
