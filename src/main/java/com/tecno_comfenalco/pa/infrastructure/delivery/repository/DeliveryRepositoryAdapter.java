package com.tecno_comfenalco.pa.infrastructure.delivery.repository;

import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.application.delivery.ports.IDeliveryRepositoryPort;
import com.tecno_comfenalco.pa.domain.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.infrastructure.delivery.entity.DeliveryDocument;
import com.tecno_comfenalco.pa.infrastructure.delivery.mapper.DeliveryMapper;
import com.tecno_comfenalco.pa.infrastructure.delivery.repository.mongo.DeliveryRepository;

@Repository
public class DeliveryRepositoryAdapter implements IDeliveryRepositoryPort {

    private DeliveryRepository deliveryRepository;

    public DeliveryRepositoryAdapter(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public boolean existsByDocumentNumber(Long documentNumber) {
        return deliveryRepository.existsByDocumentNumber(documentNumber);
    }

    @Override
    public DeliveryModel save(DeliveryModel deliveryModel) {
        DeliveryDocument delivery = DeliveryMapper.toEntity(deliveryModel);
        DeliveryDocument saved = deliveryRepository.save(delivery);

        return DeliveryMapper.toDomain(saved);
    }
}
