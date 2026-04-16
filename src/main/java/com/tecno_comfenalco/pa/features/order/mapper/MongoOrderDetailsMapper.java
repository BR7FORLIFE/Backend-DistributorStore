package com.tecno_comfenalco.pa.features.order.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.order.entity.mongo.OrderDetailDocument;
import com.tecno_comfenalco.pa.features.order.models.OrderDetailsModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoOrderDetailsMapper implements EntityMapper<OrderDetailsModel, OrderDetailDocument> {

    @Override
    public OrderDetailsModel toDto(OrderDetailDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public OrderDetailDocument toEntity(OrderDetailsModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<OrderDetailsModel> toDto(List<OrderDetailDocument> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<OrderDetailDocument> toEntity(List<OrderDetailsModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<OrderDetailsModel> toDto(Set<OrderDetailDocument> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<OrderDetailDocument> toEntity(Set<OrderDetailsModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(OrderDetailsModel dto, OrderDetailDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }

    
    
}
