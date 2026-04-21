package com.tecno_comfenalco.pa.infrastructure.catalog.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.domain.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.infrastructure.catalog.entity.CatalogDocument;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Mapper(componentModel = "spring")
public interface CatalogMapper extends EntityMapper<CatalogModel, CatalogDocument> {

}
