package com.tecno_comfenalco.pa.features.catalog.repository;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.catalog.entity.mongo.ProductsCatalogDocument;
import com.tecno_comfenalco.pa.features.catalog.mapper.MongoProductCatalogMapper;
import com.tecno_comfenalco.pa.features.catalog.models.ProductCatalogModel;
import com.tecno_comfenalco.pa.features.catalog.ports.IProductsCatalogRepositoryPort;
import com.tecno_comfenalco.pa.features.catalog.repository.mongo.IMongoProductsCatalogRepository;

@Profile("mongo")
@Repository
public class IMongoProductCatalogRepositoryAdapter implements IProductsCatalogRepositoryPort {

    private final IMongoProductsCatalogRepository repository;
    private final MongoProductCatalogMapper mapper;

    public IMongoProductCatalogRepositoryAdapter(IMongoProductsCatalogRepository repository,
            MongoProductCatalogMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductCatalogModel save(ProductCatalogModel productCatalogModel) {
        ProductsCatalogDocument entity = mapper.toEntity(productCatalogModel);
        ProductsCatalogDocument saved = repository.save(entity);

        return mapper.toDto(saved);
    }

    @Override
    public List<ProductCatalogModel> findAll() {
        return mapper.toDto(repository.findAll());
    }

}
