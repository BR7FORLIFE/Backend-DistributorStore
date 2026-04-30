package com.tecno_comfenalco.pa.application.store.dto.request;

import com.tecno_comfenalco.pa.shared.dto.DirectionDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UpdateStoreRequestDto(
        @NotBlank(message = "el nombre de la tienda no puede ser nulo ni vacio!") String name,
        @NotBlank(message = "el telefono no puede ser nulo ni vacio!") @Positive(message = "el numero de telefono debe ser positivo!") Long phoneNumber,
        DirectionDto direction) {

}
