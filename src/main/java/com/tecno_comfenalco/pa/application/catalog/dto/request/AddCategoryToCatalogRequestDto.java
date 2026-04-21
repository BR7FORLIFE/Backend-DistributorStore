package com.tecno_comfenalco.pa.application.catalog.dto.request;

import java.util.UUID;

public record AddCategoryToCatalogRequestDto(UUID catalogId, String name) {

}
