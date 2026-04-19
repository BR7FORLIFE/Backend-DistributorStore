package com.tecno_comfenalco.pa.features.catalog.repository;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.catalog.entity.postgres.CatalogEntity;
import com.tecno_comfenalco.pa.features.catalog.mapper.PostgresCatalogMapper;
import com.tecno_comfenalco.pa.features.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.features.catalog.ports.ICatalogRepositoryPort;
import com.tecno_comfenalco.pa.features.catalog.repository.postgres.IPostgresCatalogRepository;
import com.tecno_comfenalco.pa.shared.utils.helper.SafeParser;

@Profile("postgres")
@Repository
public class IPostgresCatalogRepositoryAdapter implements ICatalogRepositoryPort {

    private final IPostgresCatalogRepository repository;
    private final PostgresCatalogMapper mapper;

    public IPostgresCatalogRepositoryAdapter(IPostgresCatalogRepository repository, PostgresCatalogMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<CatalogModel> findByDistributor_Id(String distributorId) {
        Long parsedId = SafeParser.safeParseId(distributorId);

        if (parsedId == null) {
            return Optional.empty();
        }

        return repository.findByDistributor_Id(parsedId)
                .map(mapper::toDto);
    }

    @Override
    public Optional<CatalogModel> findById(String id) {
        Long parsedId = SafeParser.safeParseId(id);

        if (parsedId == null) {
            return Optional.empty();
        }
        
        return repository.findById(parsedId)
                .map(mapper::toDto);
    }

    @Override
    public CatalogModel save(CatalogModel catalogModel) {
        CatalogEntity entity = mapper.toEntity(catalogModel);
        CatalogEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }
}
