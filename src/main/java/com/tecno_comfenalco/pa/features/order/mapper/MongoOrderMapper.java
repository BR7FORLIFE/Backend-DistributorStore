package com.tecno_comfenalco.pa.features.order.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.order.entity.mongo.OrderDocument;
import com.tecno_comfenalco.pa.features.order.models.OrderModel;
import com.tecno_comfenalco.pa.features.presales.mapper.MongoPresalesMapper;
import com.tecno_comfenalco.pa.features.store.mapper.MongoStoreMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoStoreMapper.class, MongoPresalesMapper.class,
                MongoOrderDetailsMapper.class })
public interface MongoOrderMapper extends EntityMapper<OrderModel, OrderDocument> {

}
