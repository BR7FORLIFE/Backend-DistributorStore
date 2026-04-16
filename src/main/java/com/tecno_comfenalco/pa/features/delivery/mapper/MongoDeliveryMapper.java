package com.tecno_comfenalco.pa.features.delivery.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.delivery.entity.mongo.DeliveryDocument;
import com.tecno_comfenalco.pa.features.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoDeliveryMapper implements EntityMapper<DeliveryModel, DeliveryDocument> {

    @Override
    public DeliveryModel toDto(DeliveryDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public DeliveryDocument toEntity(DeliveryModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<DeliveryModel> toDto(List<DeliveryDocument> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<DeliveryDocument> toEntity(List<DeliveryModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<DeliveryModel> toDto(Set<DeliveryDocument> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<DeliveryDocument> toEntity(Set<DeliveryModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(DeliveryModel dto, DeliveryDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
