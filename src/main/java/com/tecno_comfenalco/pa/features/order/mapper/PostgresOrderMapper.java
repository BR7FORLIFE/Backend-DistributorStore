package com.tecno_comfenalco.pa.features.order.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.order.entity.postgres.OrderEntity;
import com.tecno_comfenalco.pa.features.order.models.OrderModel;
import com.tecno_comfenalco.pa.features.store.mapper.PostgresStoreMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring", uses = { PostgresStoreMapper.class, PostgresOrderDetailsMapper.class,
                PostgresOrderDetailsMapper.class })
public interface PostgresOrderMapper extends EntityMapper<OrderModel, OrderEntity> {

}
