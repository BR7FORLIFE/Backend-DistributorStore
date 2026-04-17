package com.tecno_comfenalco.pa.features.catalog.repository;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.catalog.entity.postgres.CatalogEntity;
import com.tecno_comfenalco.pa.features.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.features.catalog.ports.ICatalogRepositoryPort;
import com.tecno_comfenalco.pa.features.catalog.repository.postgres.IPostgresCatalogRepository;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Profile("postgres")
@Repository
public class IPostgresCatalogRepositoryAdapter implements ICatalogRepositoryPort {

    private final IPostgresCatalogRepository repository;
    private final EntityMapper<CatalogModel, CatalogEntity> mapper;

    public IPostgresCatalogRepositoryAdapter(IPostgresCatalogRepository repository, EntityMapper<CatalogModel, CatalogEntity> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<CatalogModel> findByDistributor_Id(Long distributorId) {
        return repository.findByDistributor_Id(distributorId)
                .map(mapper::toDto);
    }

    @Override
    public Optional<CatalogModel> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    public CatalogModel save(CatalogModel catalogModel) {
        CatalogEntity entity = mapper.toEntity(catalogModel);
        CatalogEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }
}
