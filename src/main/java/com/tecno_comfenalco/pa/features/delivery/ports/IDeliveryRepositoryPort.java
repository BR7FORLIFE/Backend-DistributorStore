package com.tecno_comfenalco.pa.features.delivery.ports;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.features.delivery.model.DeliveryModel;

public interface IDeliveryRepositoryPort {
    Optional<DeliveryModel> findById(Long id);

    Optional<DeliveryModel> findByName(String name);

    List<DeliveryModel> findAll();

    DeliveryModel save(DeliveryModel deliveryModel);

    boolean existsByDocumentNumber(Long documentNumber);
}
