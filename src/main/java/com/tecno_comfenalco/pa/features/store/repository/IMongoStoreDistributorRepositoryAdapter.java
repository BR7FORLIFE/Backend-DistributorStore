package com.tecno_comfenalco.pa.features.store.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.store.entity.mongo.StoresDistributorsDocument;
import com.tecno_comfenalco.pa.features.store.mapper.MongoStoreDistributorMapper;
import com.tecno_comfenalco.pa.features.store.models.StoreDistributorModel;
import com.tecno_comfenalco.pa.features.store.ports.IStoreDistributorRepositoryPort;
import com.tecno_comfenalco.pa.features.store.repository.mongo.IMongoStoreDistributorRepository;
import com.tecno_comfenalco.pa.shared.utils.helper.SafeParser;

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
    public Optional<StoreDistributorModel> findByStore_IdAndDistributor_Id(String storeId, String distributorId) {
        Long parseStoreId = SafeParser.safeParseId(storeId);
        Long parseDistributorId = SafeParser.safeParseId(distributorId);

        if (parseStoreId == null || parseDistributorId == null) {
            return Optional.empty();
        }

        return repository.findByStore_IdAndDistributor_Id(parseStoreId, parseDistributorId)
                .map(mapper::toDto);
    }

    @Override
    public List<StoreDistributorModel> findByStore_Id(String storeId) {
        Long parserStoreId = SafeParser.safeParseId(storeId);

        if (parserStoreId == null) {
            return List.of();
        }

        return repository.findByStore_Id(parserStoreId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<StoreDistributorModel> findByDistributor_Id(String distributorId) {

        Long parseDistributorId = SafeParser.safeParseId(distributorId);

        if (parseDistributorId == null) {
            return List.of();
        }

        return repository.findByDistributor_Id(parseDistributorId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public boolean existsByStore_IdAndDistributor_Id(String storeId, String distributorId) {
        Long parseStoreId = SafeParser.safeParseId(storeId);
        Long parseDistributorId = SafeParser.safeParseId(distributorId);

        if (parseStoreId == null || parseDistributorId == null) {
            return false;
        }

        return repository.existsByStore_IdAndDistributor_Id(parseStoreId, parseDistributorId);
    }

}
