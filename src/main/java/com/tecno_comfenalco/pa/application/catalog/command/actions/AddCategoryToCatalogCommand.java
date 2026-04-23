package com.tecno_comfenalco.pa.application.catalog.command.actions;

import java.util.List;
import java.util.UUID;

public record AddCategoryToCatalogCommand(UUID distributorId, UUID catalogId, String name,
                List<UUID> products) {

}
