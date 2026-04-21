package com.tecno_comfenalco.pa.infrastructure.catalog.repository;

import com.tecno_comfenalco.pa.infrastructure.product.repository.mongo.ProductRepository;
import java.util.UUID;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.application.catalog.port.ICatalogRepositoryPort;
import com.tecno_comfenalco.pa.domain.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.domain.category.models.CategoryModel;
import com.tecno_comfenalco.pa.infrastructure.catalog.entity.CatalogDocument;
import com.tecno_comfenalco.pa.infrastructure.catalog.mapper.CatalogMapper;
import com.tecno_comfenalco.pa.infrastructure.catalog.repository.mongo.CatalogRepository;
import com.tecno_comfenalco.pa.infrastructure.category.entity.CategoryEmbeddedEntity;
import com.tecno_comfenalco.pa.infrastructure.category.mapper.CategoryMapper;

@Repository
public class CatalogRepositoryAdapter implements ICatalogRepositoryPort {

    private final CatalogRepository catalogRepository;
    private final CatalogMapper catalogMapper;
    private final CategoryMapper categoryMapper;
    private final MongoTemplate mongoTemplate;

    public CatalogRepositoryAdapter(CatalogRepository catalogRepository, CatalogMapper catalogMapper,
            MongoTemplate mongoTemplate, CategoryMapper categoryMapper) {
        this.catalogRepository = catalogRepository;
        this.catalogMapper = catalogMapper;
        this.mongoTemplate = mongoTemplate;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public boolean existsByDistributorIdAndCode(UUID distributorId, String code) {
        return catalogRepository.existsByIdAndCatalogCode(distributorId, code);
    }

    @Override
    public CatalogModel save(CatalogModel catalogModel) {
        CatalogDocument catalogDocument = catalogMapper.toEntity(catalogModel);
        CatalogDocument saved = catalogRepository.save(catalogDocument);

        return catalogMapper.toDto(saved);
    }

    @Override
    public boolean existsCategoryNameInCatalog(UUID catalogId, String categoryName) {
        return catalogRepository.existsCategoryNameInCatalog(catalogId, categoryName);
    }

    @Override
    public void addCategoryToCatalog(UUID catalogId, CategoryModel categoryModel) {
        Query query = new Query(Criteria.where("_id").is(catalogId));
        CategoryEmbeddedEntity categoryEmbeddedEntity = categoryMapper.toEntity(categoryModel);

        Update update = new Update().push("categories", categoryEmbeddedEntity);
        mongoTemplate.updateFirst(query, update, CatalogDocument.class);
    }
}
