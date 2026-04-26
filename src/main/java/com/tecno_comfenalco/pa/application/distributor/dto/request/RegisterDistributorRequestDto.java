package com.tecno_comfenalco.pa.application.distributor.dto.request;

import java.util.UUID;

import com.tecno_comfenalco.pa.shared.dto.DirectionDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record RegisterDistributorRequestDto(
        @NotBlank(message = "no puede ser nulo el userId") UUID userId,
        @NotNull(message = "El nit de la distribuidora no puede ser nulo!") String NIT,
        @NotNull(message = "El nombre de la distribuidora no puede ser nulo!") String name,
        @NotBlank(message = "El numero de telefono no puede ser nulo o vacio!") @Positive(message = "el telefono no puede ser negativo") @Size(min = 10, max = 20) Long phoneNumber,
        @Email(message = "Debe tener un formato correcto de email!") String email,
        DirectionDto direction) {
}
