package com.tecno_comfenalco.pa.features.order.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.order.entity.mongo.OrderDocument;
import com.tecno_comfenalco.pa.features.order.models.OrderModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoOrderMapper implements EntityMapper<OrderModel, OrderDocument>{

    @Override
    public OrderModel toDto(OrderDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public OrderDocument toEntity(OrderModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<OrderModel> toDto(List<OrderDocument> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<OrderDocument> toEntity(List<OrderModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<OrderModel> toDto(Set<OrderDocument> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<OrderDocument> toEntity(Set<OrderModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(OrderModel dto, OrderDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
