package com.tecno_comfenalco.pa.features.store.repository.postgres;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.features.store.entity.postgres.StoreEntity;

public interface IPostgresStoreRepository extends JpaRepository<StoreEntity, Long> {
    StoreEntity save(StoreEntity storeEntity);

    Optional<StoreEntity> findById(Long id);

    Optional<StoreEntity> findByNIT(Long NIT);

    Optional<StoreEntity> findByUser_Id(Long userId);

    List<StoreEntity> findAll();

    boolean existsByNIT(Long NIT);

    boolean existsById(Long NIT);

    void deleteById(Long id);
}
