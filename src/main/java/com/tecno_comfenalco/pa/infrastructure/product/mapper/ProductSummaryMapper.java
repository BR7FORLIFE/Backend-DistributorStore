package com.tecno_comfenalco.pa.infrastructure.product.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.domain.product.model.ProductSummaryModel;
import com.tecno_comfenalco.pa.infrastructure.product.entity.ProductSummaryEmbeddedEntity;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Mapper(componentModel = "spring")
public interface ProductSummaryMapper extends EntityMapper<ProductSummaryModel, ProductSummaryEmbeddedEntity> {

}
