package com.tecno_comfenalco.pa.features.delivery.repository.postgres;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.features.delivery.entity.postgres.DeliveryEntity;

public interface IPostgresDeliveryRepository extends JpaRepository<DeliveryEntity, Long> {
    Optional<DeliveryEntity> findById(Long id);

    Optional<DeliveryEntity> findByName(String name);

    List<DeliveryEntity> findAll();

    DeliveryEntity save(DeliveryEntity presalesEntity);

    boolean existsByDocumentNumber(Long documentNumber);
}
