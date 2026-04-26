package com.tecno_comfenalco.pa.application.presales.command.actions;

import java.util.UUID;

public record EditPresalesCommand(UUID distributorId, UUID presalesId, String name, Long phoneNumber) {

}
