package com.tecno_comfenalco.pa.features.store.repository.postgres;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.features.store.entity.postgres.StoresDistributorsEntity;

public interface IPostgresStoreDistributorRepository extends JpaRepository<StoresDistributorsEntity, Long> {
    StoresDistributorsEntity save(StoresDistributorsEntity entity);

    Optional<StoresDistributorsEntity> findByStore_IdAndDistributor_Id(Long storeId, Long distributorId);

    List<StoresDistributorsEntity> findByStore_Id(Long storeId);

    List<StoresDistributorsEntity> findByDistributor_Id(Long distributorId);

    boolean existsByStore_IdAndDistributor_Id(Long storeId, Long distributorId);
}
