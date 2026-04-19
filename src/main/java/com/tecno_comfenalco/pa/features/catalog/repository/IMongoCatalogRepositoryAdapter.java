package com.tecno_comfenalco.pa.features.catalog.repository;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.catalog.entity.mongo.CatalogDocument;
import com.tecno_comfenalco.pa.features.catalog.mapper.MongoCatalogMapper;
import com.tecno_comfenalco.pa.features.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.features.catalog.ports.ICatalogRepositoryPort;
import com.tecno_comfenalco.pa.features.catalog.repository.mongo.IMongoCatalogRepository;

@Profile("mongo")
@Repository
public class IMongoCatalogRepositoryAdapter implements ICatalogRepositoryPort {

    private final IMongoCatalogRepository repository;
    private final MongoCatalogMapper mapper;

    public IMongoCatalogRepositoryAdapter(IMongoCatalogRepository repository, MongoCatalogMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CatalogModel save(CatalogModel catalogModel) {
        CatalogDocument document = mapper.toEntity(catalogModel);
        CatalogDocument saved = repository.save(document);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<CatalogModel> findById(Long id) {
        return repository.findById(id.toString())
                .map(mapper::toDto);
    }

    @Override
    public Optional<CatalogModel> findByDistributor_Id(Long distributorId) {
        return repository.findByDistributorId(distributorId.toString())
                .map(mapper::toDto);
    }
}
