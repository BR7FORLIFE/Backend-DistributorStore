package com.tecno_comfenalco.pa.application.store.command.actions;

import java.util.UUID;

import com.tecno_comfenalco.pa.shared.dto.DirectionDto;

public record RegisterStoreCommand(UUID userId, String name, String nit, Long phoneNumber, String email,
        DirectionDto direction) {

}
