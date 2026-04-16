package com.tecno_comfenalco.pa.features.presales.repository.postgres;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.features.presales.entity.postgres.PresalesEntity;

public interface IPostgresPresalesRepository extends JpaRepository<PresalesEntity, Long> {
    Optional<PresalesEntity> findById(Long id);

    Optional<PresalesEntity> findByName(String name);

    Optional<PresalesEntity> findByUser_Id(Long userId);

    List<PresalesEntity> findAll();

    PresalesEntity save(PresalesEntity presalesEntity);

    boolean existsByDocumentNumber(Long documentNumber);
}
