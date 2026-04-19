package com.tecno_comfenalco.pa.features.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.store.entity.postgres.StoreEntity;
import com.tecno_comfenalco.pa.features.store.mapper.PostgresStoreMapper;
import com.tecno_comfenalco.pa.features.store.models.StoreModel;
import com.tecno_comfenalco.pa.features.store.ports.IStoreRepositoryRepositoryPort;
import com.tecno_comfenalco.pa.features.store.repository.postgres.IPostgresStoreRepository;

@Profile("postgres")
@Repository
public class IPostgresStoreRepositoryAdapter implements IStoreRepositoryRepositoryPort {

    private final IPostgresStoreRepository repository;
    private final PostgresStoreMapper mapper;

    public IPostgresStoreRepositoryAdapter(IPostgresStoreRepository repository,
            PostgresStoreMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StoreModel save(StoreModel StoreModel) {
        StoreEntity entity = mapper.toEntity(StoreModel);
        StoreEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<StoreModel> findById(Long id) {
        return repository.findById(id).map(mapper::toDto);
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
        return repository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
