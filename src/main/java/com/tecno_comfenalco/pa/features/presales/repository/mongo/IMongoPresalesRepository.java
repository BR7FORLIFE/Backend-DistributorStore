package com.tecno_comfenalco.pa.features.presales.repository.mongo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.presales.entity.mongo.PresalesDocument;

public interface IMongoPresalesRepository extends MongoRepository<PresalesDocument, String> {
    Optional<PresalesDocument> findById(String id);

    Optional<PresalesDocument> findByName(String name);

    Optional<PresalesDocument> findByUser_Id(String userId);

    List<PresalesDocument> findAll();

    PresalesDocument save(PresalesDocument presalesDocument);

    boolean existsByDocumentNumber(Long documentNumber);
}
