package com.tecno_comfenalco.pa.features.distributor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.distributor.entity.mongo.DistributorDocument;
import com.tecno_comfenalco.pa.features.distributor.mapper.MongoDistributorMapper;
import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;
import com.tecno_comfenalco.pa.features.distributor.ports.IDistributorRepositoryPort;
import com.tecno_comfenalco.pa.features.distributor.repository.mongo.IMongoDistributorRepository;

@Profile("mongo")
@Repository
public class IMongoDistributorRepositoryAdapter implements IDistributorRepositoryPort {

    private final IMongoDistributorRepository repository;
    private final MongoDistributorMapper mapper;

    public IMongoDistributorRepositoryAdapter(IMongoDistributorRepository repository,
            MongoDistributorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DistributorModel> findById(Long id) {
        return repository.findById(id.toString())
                .map(mapper::toDto);
    }

    @Override
    public Optional<DistributorModel> findByName(String name) {
        return repository.findByName(name)
                .map(mapper::toDto);
    }

    @Override
    public DistributorModel save(DistributorModel DistributorModel) {
        DistributorDocument document = mapper.toEntity(DistributorModel);
        DistributorDocument saved = repository.save(document);
        return mapper.toDto(saved);
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public Optional<DistributorModel> findByUser_Id(Long userId) {
        return repository.findByUser_Id(userId.toString())
                .map(mapper::toDto);
    }

    @Override
    public Optional<DistributorModel> findByNIT(Long NIT) {
        return repository.findByNIT(NIT.toString())
                .map(mapper::toDto);
    }

    @Override
    public List<DistributorModel> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
