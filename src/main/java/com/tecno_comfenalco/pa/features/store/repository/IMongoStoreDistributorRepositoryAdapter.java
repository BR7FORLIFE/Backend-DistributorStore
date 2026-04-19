package com.tecno_comfenalco.pa.features.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.store.entity.mongo.StoresDistributorsDocument;
import com.tecno_comfenalco.pa.features.store.mapper.MongoStoreDistributorMapper;
import com.tecno_comfenalco.pa.features.store.models.StoreDistributorModel;
import com.tecno_comfenalco.pa.features.store.ports.IStoreDistributorRepositoryPort;
import com.tecno_comfenalco.pa.features.store.repository.mongo.IMongoStoreDistributorRepository;

@Profile("mongo")
@Repository
public class IMongoStoreDistributorRepositoryAdapter implements IStoreDistributorRepositoryPort {

    private final IMongoStoreDistributorRepository repository;
    private final MongoStoreDistributorMapper mapper;

    public IMongoStoreDistributorRepositoryAdapter(IMongoStoreDistributorRepository repository,
            MongoStoreDistributorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StoreDistributorModel save(StoreDistributorModel entity) {
        StoresDistributorsDocument storeEntity = mapper.toEntity(entity);
        StoresDistributorsDocument saved = repository.save(storeEntity);
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
