package com.tecno_comfenalco.pa.features.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.store.entity.postgres.StoresDistributorsEntity;
import com.tecno_comfenalco.pa.features.store.mapper.PostgresStoreDistributorMapper;
import com.tecno_comfenalco.pa.features.store.models.StoreDistributorModel;
import com.tecno_comfenalco.pa.features.store.ports.IStoreDistributorRepositoryPort;
import com.tecno_comfenalco.pa.features.store.repository.postgres.IPostgresStoreDistributorRepository;
import com.tecno_comfenalco.pa.shared.utils.helper.SafeParser;

@Profile("postgres")
@Repository
public class IPostgresStoresDistributorsRepositoryAdapter implements IStoreDistributorRepositoryPort {

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
    public Optional<StoreDistributorModel> findByStore_IdAndDistributor_Id(String storeId, String distributorId) {
        Long parsedStoreId = SafeParser.safeParseId(storeId);
        Long parsedDistributorId = SafeParser.safeParseId(distributorId);

        if (parsedStoreId == null || parsedDistributorId == null) {
            return Optional.empty();
        }

        return repository.findByStore_IdAndDistributor_Id(parsedStoreId, parsedDistributorId)
                .map(mapper::toDto);
    }

    @Override
    public List<StoreDistributorModel> findByStore_Id(String storeId) {
        Long parsedStoreId = SafeParser.safeParseId(storeId);

        if (parsedStoreId == null) {
            return List.of();
        }

        return repository.findByStore_Id(parsedStoreId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<StoreDistributorModel> findByDistributor_Id(String distributorId) {
        Long parsedDistributorId = SafeParser.safeParseId(distributorId);

        if (parsedDistributorId == null) {
            return List.of();
        }

        return repository.findByDistributor_Id(parsedDistributorId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public boolean existsByStore_IdAndDistributor_Id(String storeId, String distributorId) {
        Long parsedStoreId = SafeParser.safeParseId(storeId);
        Long parsedDistributorId = SafeParser.safeParseId(distributorId);

        if (parsedStoreId == null || parsedDistributorId == null) {
            return false;
        }

        return repository.existsByStore_IdAndDistributor_Id(parsedStoreId, parsedDistributorId);
    }

}
