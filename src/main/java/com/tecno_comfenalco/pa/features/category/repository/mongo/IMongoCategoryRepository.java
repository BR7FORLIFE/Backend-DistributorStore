package com.tecno_comfenalco.pa.features.category.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.category.entity.mongo.CategoryDocument;

public interface IMongoCategoryRepository extends MongoRepository<CategoryDocument, String> {
    List<CategoryDocument> findByCatalog_Id(String category_id);
}
