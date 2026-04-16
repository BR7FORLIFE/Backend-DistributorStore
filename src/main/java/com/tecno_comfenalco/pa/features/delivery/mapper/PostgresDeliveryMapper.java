package com.tecno_comfenalco.pa.features.delivery.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.delivery.entity.postgres.DeliveryEntity;
import com.tecno_comfenalco.pa.features.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresDeliveryMapper implements EntityMapper<DeliveryModel, DeliveryEntity>{

    @Override
    public DeliveryModel toDto(DeliveryEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public DeliveryEntity toEntity(DeliveryModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<DeliveryModel> toDto(List<DeliveryEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<DeliveryEntity> toEntity(List<DeliveryModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<DeliveryModel> toDto(Set<DeliveryEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<DeliveryEntity> toEntity(Set<DeliveryModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(DeliveryModel dto, DeliveryEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
