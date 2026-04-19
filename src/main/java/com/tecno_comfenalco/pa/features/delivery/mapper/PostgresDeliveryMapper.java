package com.tecno_comfenalco.pa.features.delivery.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.delivery.entity.postgres.DeliveryEntity;
import com.tecno_comfenalco.pa.features.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.features.distributor.mapper.PostgresDistributorMapper;
import com.tecno_comfenalco.pa.features.routes.deliveries.mapper.PostgresDeliveryRoutesMapper;
import com.tecno_comfenalco.pa.security.mapper.PostgresUserMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring", uses = { PostgresDeliveryRoutesMapper.class, PostgresUserMapper.class,
        PostgresDistributorMapper.class })
public interface PostgresDeliveryMapper extends EntityMapper<DeliveryModel, DeliveryEntity> {

}
