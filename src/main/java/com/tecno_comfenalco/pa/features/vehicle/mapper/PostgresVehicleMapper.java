package com.tecno_comfenalco.pa.features.vehicle.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.delivery.mapper.PostgresDeliveryMapper;
import com.tecno_comfenalco.pa.features.distributor.mapper.PostgresDistributorMapper;
import com.tecno_comfenalco.pa.features.vehicle.entity.postgres.VehicleEntity;
import com.tecno_comfenalco.pa.features.vehicle.models.VehicleModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring", uses = { PostgresDeliveryMapper.class, PostgresDistributorMapper.class })
public interface PostgresVehicleMapper extends EntityMapper<VehicleModel, VehicleEntity> {

}
