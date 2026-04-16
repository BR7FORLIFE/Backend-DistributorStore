package com.tecno_comfenalco.pa.features.routes.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.features.delivery.entity.postgres.DeliveryEntity;

public interface IPostgresDeliveryRoutesRepository extends JpaRepository<DeliveryEntity, Long> {

}
