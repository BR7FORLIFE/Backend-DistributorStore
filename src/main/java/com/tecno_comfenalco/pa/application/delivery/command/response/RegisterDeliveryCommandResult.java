package com.tecno_comfenalco.pa.application.delivery.command.response;

import java.util.UUID;

public record RegisterDeliveryCommandResult(UUID distributorId, UUID deliveryId, String message) {

}
