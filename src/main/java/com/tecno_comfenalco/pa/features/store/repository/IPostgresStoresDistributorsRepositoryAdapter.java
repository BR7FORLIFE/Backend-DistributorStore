package com.tecno_comfenalco.pa.features.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.store.entity.postgres.StoreEntity;
import com.tecno_comfenalco.pa.features.store.entity.postgres.StoresDistributorsEntity;
import com.tecno_comfenalco.pa.features.store.mapper.PostgresStoreDistributorMapper;
import com.tecno_comfenalco.pa.features.store.models.StoreDistributorModel;
import com.tecno_comfenalco.pa.features.store.ports.IStoreDistributorPort;
import com.tecno_comfenalco.pa.features.store.repository.postgres.IPostgresStoreDistributorRepository;

@Profile("postgres")
@Repository
public class IPostgresStoresDistributorsRepositoryAdapter implements IStoreDistributorPort {

    private final IPostgresStoreDistributorRepository repository;
    private final PostgresStoreDistributorMapper mapper;

    public IPostgresStoresDistributorsRepositoryAdapter(IPostgresStoreDistributorRepository repository,
            PostgresStoreDistributorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StoreDistributorModel save(StoreDistributorModel entity) {
        StoresDistributorsEntity storeEntity = mapper.toEntity(entity);
        StoresDistributorsEntity saved = repository.save(storeEntity);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<StoreDistributorModel> findByStore_IdAndDistributor_Id(Long storeId, Long distributorId) {
        return repository.findByStore_IdAndDistributor_Id(storeId, distributorId)
                .map(mapper::toDto);
    }

    @Override
    public List<StoreDistributorModel> findByStore_Id(Long storeId) {
        return repository.findByStore_Id(storeId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<StoreDistributorModel> findByDistributor_Id(Long distributorId) {
        return repository.findByDistributor_Id(distributorId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public boolean existsByStore_IdAndDistributor_Id(Long storeId, Long distributorId) {
        return repository.existsByStore_IdAndDistributor_Id(storeId, distributorId);
    }
}
