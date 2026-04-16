package com.tecno_comfenalco.pa.features.order.repository.postgres;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.features.order.entity.postgres.OrderEntity;

public interface IPostgresOrderRepository extends JpaRepository<OrderEntity, UUID>{
    Optional<OrderEntity> findByid(UUID id);

    OrderEntity save(OrderEntity orderEntity);

    List<OrderEntity> findAll();

    List<OrderEntity> findByStore_Id(Long storeId);

    List<OrderEntity> findByPresales_Id(Long presalesId);

    boolean existsByid(UUID id);

    void deleteById(UUID id);
}
