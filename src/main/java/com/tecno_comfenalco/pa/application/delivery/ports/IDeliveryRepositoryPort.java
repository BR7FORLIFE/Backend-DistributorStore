package com.tecno_comfenalco.pa.application.delivery.ports;

import com.tecno_comfenalco.pa.domain.delivery.model.DeliveryModel;

public interface IDeliveryRepositoryPort {
    boolean existsByDocumentNumber(Long documentNumber);

    DeliveryModel save(DeliveryModel deliveryModel);
}
