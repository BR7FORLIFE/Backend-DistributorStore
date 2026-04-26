package com.tecno_comfenalco.pa.application.presales.command.actions;

import java.util.UUID;

public record GetPresalesInfoCommand(UUID presaleId, UUID distributorId) {

}
