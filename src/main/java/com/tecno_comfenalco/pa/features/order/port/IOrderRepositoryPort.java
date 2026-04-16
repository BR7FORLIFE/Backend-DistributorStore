package com.tecno_comfenalco.pa.features.order.port;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.features.order.models.OrderModel;

public interface IOrderRepositoryPort {
    Optional<OrderModel> findByid(String id);

    OrderModel save(OrderModel OrderModel);

    List<OrderModel> findAll();

    List<OrderModel> findByStore_Id(String storeId);

    List<OrderModel> findByPresales_Id(String presalesId);

    boolean existsByid(String id);

    void deleteById(String id);
}
