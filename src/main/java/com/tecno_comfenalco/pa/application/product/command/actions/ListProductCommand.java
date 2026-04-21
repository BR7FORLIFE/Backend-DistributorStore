package com.tecno_comfenalco.pa.application.product.command.actions;

import java.util.UUID;

public record ListProductCommand(UUID distributorId, int page, int size, String sortBy, String direction) {

}
