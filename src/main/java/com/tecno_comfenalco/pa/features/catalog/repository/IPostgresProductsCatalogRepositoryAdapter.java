package com.tecno_comfenalco.pa.features.catalog.repository;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.catalog.entity.postgres.ProductsCatalogEntity;
import com.tecno_comfenalco.pa.features.catalog.models.ProductCatalogModel;
import com.tecno_comfenalco.pa.features.catalog.ports.IProductsCatalogRepositoryPort;
import com.tecno_comfenalco.pa.features.catalog.repository.postgres.IPostgresProductsCatalogRepository;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Profile("postgres")
@Repository
public class IPostgresProductsCatalogRepositoryAdapter implements IProductsCatalogRepositoryPort {

    private final EntityMapper<ProductCatalogModel, ProductsCatalogEntity> mapper;
    private final IPostgresProductsCatalogRepository repository;

    public IPostgresProductsCatalogRepositoryAdapter(IPostgresProductsCatalogRepository repository,
            EntityMapper<ProductCatalogModel, ProductsCatalogEntity> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductCatalogModel save(ProductCatalogModel productCatalogModel) {
        ProductsCatalogEntity entity = mapper.toEntity(productCatalogModel);
        ProductsCatalogEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public List<ProductCatalogModel> findAll() {
        return mapper.toDto(repository.findAll());
    }

}
