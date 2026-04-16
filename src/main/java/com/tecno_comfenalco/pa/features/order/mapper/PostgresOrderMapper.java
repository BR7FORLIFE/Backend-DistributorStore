package com.tecno_comfenalco.pa.features.order.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.order.entity.postgres.OrderEntity;
import com.tecno_comfenalco.pa.features.order.models.OrderModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresOrderMapper implements  EntityMapper<OrderModel, OrderEntity> {

    @Override
    public OrderModel toDto(OrderEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public OrderEntity toEntity(OrderModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<OrderModel> toDto(List<OrderEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<OrderEntity> toEntity(List<OrderModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<OrderModel> toDto(Set<OrderEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<OrderEntity> toEntity(Set<OrderModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(OrderModel dto, OrderEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
