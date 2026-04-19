package com.tecno_comfenalco.pa.features.routes.presales.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.routes.models.presales.PresalesRoutesModel;
import com.tecno_comfenalco.pa.features.routes.presales.entity.postgres.PresalesRoutesEntity;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring")
public interface PostgresPresalesRoutesMapper extends EntityMapper<PresalesRoutesModel, PresalesRoutesEntity> {

}
