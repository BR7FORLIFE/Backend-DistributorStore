package com.tecno_comfenalco.pa.infrastructure.storeAssignment.repository.mongo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.domain.storeAssignment.models.StoreAssignmentModel;
import com.tecno_comfenalco.pa.infrastructure.storeAssignment.entity.StoreAssignmentDocument;

public interface StoreAssignmentRepository extends MongoRepository<StoreAssignmentDocument, UUID> {
    List<StoreAssignmentModel> findAllByStoreId(UUID StoreId);
}
