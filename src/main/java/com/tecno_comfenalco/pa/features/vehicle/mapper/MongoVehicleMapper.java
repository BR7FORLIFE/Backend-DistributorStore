package com.tecno_comfenalco.pa.features.vehicle.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.delivery.mapper.MongoDeliveryMapper;
import com.tecno_comfenalco.pa.features.distributor.mapper.MongoDistributorMapper;
import com.tecno_comfenalco.pa.features.vehicle.entity.mongo.VehicleDocument;
import com.tecno_comfenalco.pa.features.vehicle.models.VehicleModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoDeliveryMapper.class, MongoDistributorMapper.class })
public interface MongoVehicleMapper extends EntityMapper<VehicleModel, VehicleDocument> {

}
