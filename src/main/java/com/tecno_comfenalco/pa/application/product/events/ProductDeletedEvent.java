package com.tecno_comfenalco.pa.application.product.events;

import java.util.UUID;

public record ProductDeletedEvent(
        UUID id,
        UUID distributorId,
        int quantity // <- en el caso de los inventarios si se quiere actualizar la cantidad en el inventario
) {

}
