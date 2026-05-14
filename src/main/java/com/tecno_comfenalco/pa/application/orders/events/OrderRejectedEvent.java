package com.tecno_comfenalco.pa.application.orders.events;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.orders.model.OrderProductModel;

public record OrderRejectedEvent(
        UUID distributorId,
        List<OrderProductModel> orderProducts) {

}
