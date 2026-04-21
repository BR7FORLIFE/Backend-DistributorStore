package com.tecno_comfenalco.pa.application.product.command.actions;

import java.util.UUID;

import com.tecno_comfenalco.pa.shared.enums.Unit;

public record EditProductCommand(UUID distributorId, UUID productId, String sku, String name, Unit unit) {

}
