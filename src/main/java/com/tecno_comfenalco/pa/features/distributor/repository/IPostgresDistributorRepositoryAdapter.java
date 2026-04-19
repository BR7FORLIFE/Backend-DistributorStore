package com.tecno_comfenalco.pa.features.distributor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.distributor.entity.postgres.DistributorEntity;
import com.tecno_comfenalco.pa.features.distributor.mapper.PostgresDistributorMapper;
import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;
import com.tecno_comfenalco.pa.features.distributor.ports.IDistributorRepositoryPort;
import com.tecno_comfenalco.pa.features.distributor.repository.postgres.IPostgresDistributorRepository;
import com.tecno_comfenalco.pa.shared.utils.helper.SafeParser;

@Profile("postgres")
@Repository
public class IPostgresDistributorRepositoryAdapter implements IDistributorRepositoryPort {

    private final IPostgresDistributorRepository repository;
    private final PostgresDistributorMapper mapper;

    public IPostgresDistributorRepositoryAdapter(IPostgresDistributorRepository repository,
            PostgresDistributorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DistributorModel> findById(String id) {
        Long parsedId = SafeParser.safeParseId(id);

        if (parsedId == null) {
            return Optional.empty();
        }
        return repository.findById(parsedId)
                .map(mapper::toDto);
    }

    @Override
    public Optional<DistributorModel> findByName(String name) {
        return repository.findByName(name)
                .map(mapper::toDto);
    }

    @Override
    public List<DistributorModel> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public DistributorModel save(DistributorModel DistributorModel) {
        DistributorEntity entity = mapper.toEntity(DistributorModel);
        DistributorEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public Optional<DistributorModel> findByUser_Id(String userId) {
        Long parsedId = SafeParser.safeParseId(userId);

        if (parsedId == null) {
            return Optional.empty();
        }
        return repository.findByUser_Id(parsedId)
                .map(mapper::toDto);
    }

    @Override
    public Optional<DistributorModel> findByNIT(Long NIT) {
        return repository.findByNIT(NIT)
                .map(mapper::toDto);
    }

}
