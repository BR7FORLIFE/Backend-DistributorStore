package com.tecno_comfenalco.pa.features.routes.deliveries.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.routes.deliveries.entity.postgres.DeliveryRoutesEntity;
import com.tecno_comfenalco.pa.features.routes.models.delivery.DeliveryRoutesModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring")
public interface PostgresDeliveryRoutesMapper extends EntityMapper<DeliveryRoutesModel, DeliveryRoutesEntity> {

}
