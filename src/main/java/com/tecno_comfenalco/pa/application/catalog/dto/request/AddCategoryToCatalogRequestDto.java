package com.tecno_comfenalco.pa.application.catalog.dto.request;

import java.util.List;
import java.util.UUID;

public record AddCategoryToCatalogRequestDto(UUID catalogId, String name, List<UUID> products) {

}
