package com.tecno_comfenalco.pa.features.distributor.repository.postgres;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.features.distributor.entity.postgres.DistributorEntity;

public interface IPostgresDistributorRepository extends JpaRepository<DistributorEntity, Long>{

    Optional<DistributorEntity> findById(Long id);

    Optional<DistributorEntity> findByName(String name);

    List<DistributorEntity> findAll();

    DistributorEntity save(DistributorEntity distributorEntity);

    boolean existsByName(String name);

    Optional<DistributorEntity> findByUser_Id(Long userId);

    Optional<DistributorEntity> findByNIT(Long NIT);
}
