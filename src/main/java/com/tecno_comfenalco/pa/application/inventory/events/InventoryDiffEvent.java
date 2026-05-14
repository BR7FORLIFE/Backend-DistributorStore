package com.tecno_comfenalco.pa.application.inventory.events;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.orders.model.OrderProductModel;
import com.tecno_comfenalco.pa.infrastructure.inventory.events.listeners.InventoryListener.OP;

public record InventoryDiffEvent(
                UUID distributorId,
                List<OrderProductModel> orderProducts,
                OP op) {

}
