package com.tecno_comfenalco.pa.features.order.mapper;


import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.order.entity.postgres.OrderEntity;
import com.tecno_comfenalco.pa.features.order.models.OrderDetailsModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresOrderDetailsMapper implements EntityMapper<OrderDetailsModel, OrderEntity> {

    @Override
    public OrderDetailsModel toDto(OrderEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public OrderEntity toEntity(OrderDetailsModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<OrderDetailsModel> toDto(List<OrderEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<OrderEntity> toEntity(List<OrderDetailsModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<OrderDetailsModel> toDto(Set<OrderEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<OrderEntity> toEntity(Set<OrderDetailsModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(OrderDetailsModel dto, OrderEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }

    
    
}
