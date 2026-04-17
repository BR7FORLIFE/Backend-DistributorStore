package com.tecno_comfenalco.pa.features.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.store.entity.mongo.StoreDocument;
import com.tecno_comfenalco.pa.features.store.models.StoreModel;
import com.tecno_comfenalco.pa.features.store.ports.IStoreRepositoryPort;
import com.tecno_comfenalco.pa.features.store.repository.mongo.IMongoStoreRepository;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Profile("mongo")
@Repository
public class IMongoStoreRepositoryAdapter implements IStoreRepositoryPort {

    private final IMongoStoreRepository repository;
    private final EntityMapper<StoreModel, StoreDocument> mapper;

    public IMongoStoreRepositoryAdapter(IMongoStoreRepository repository,
            EntityMapper<StoreModel, StoreDocument> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StoreModel save(StoreModel StoreModel) {
        StoreDocument entity = mapper.toEntity(StoreModel);
        StoreDocument saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<StoreModel> findById(Long id) {
        return repository.findById(id.toString()).map(mapper::toDto);
    }

    @Override
    public Optional<StoreModel> findByNIT(Long NIT) {
        return repository.findByNIT(NIT).map(mapper::toDto);
    }

    @Override
    public Optional<StoreModel> findByUser_Id(Long userId) {
        return repository.findByUser_Id(userId).map(mapper::toDto);
    }

    @Override
    public List<StoreModel> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public boolean existsByNIT(Long NIT) {
        return repository.existsByNIT(NIT);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id.toString());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id.toString());
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
