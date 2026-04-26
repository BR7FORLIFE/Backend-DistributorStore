package com.tecno_comfenalco.pa.infrastructure.delivery.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecno_comfenalco.pa.application.delivery.command.actions.ListAllDeliveryCommand;
import com.tecno_comfenalco.pa.application.delivery.command.actions.RegisterDeliveryCommand;
import com.tecno_comfenalco.pa.application.delivery.command.response.ListAllDeliveryCommandResult;
import com.tecno_comfenalco.pa.application.delivery.command.response.RegisterDeliveryCommandResult;
import com.tecno_comfenalco.pa.application.delivery.dto.request.RegisterDeliveryRequestDto;
import com.tecno_comfenalco.pa.application.delivery.dto.response.ListAllDeliveryResponseDto;
import com.tecno_comfenalco.pa.application.delivery.dto.response.RegisterDeliveryResponseDto;
import com.tecno_comfenalco.pa.application.delivery.usecases.DeliveryUseCase;
import com.tecno_comfenalco.pa.infrastructure.security.CustomUserDetails;
import com.tecno_comfenalco.pa.shared.utils.http.DirectionEnum;
import com.tecno_comfenalco.pa.shared.utils.http.RequestParams;

import jakarta.validation.Valid;

@PreAuthorize("hasRole('DISTRIBUTOR')")
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private DeliveryUseCase deliveryUseCase;

    public DeliveryController(DeliveryUseCase deliveryUseCase) {
        this.deliveryUseCase = deliveryUseCase;
    }

    @PostMapping
    public ResponseEntity<RegisterDeliveryResponseDto> registerDelivery(
            @RequestBody @Valid RegisterDeliveryRequestDto dto, Authentication authentication) {
        CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();

        RegisterDeliveryCommand cmd = new RegisterDeliveryCommand(details.getUserId(), dto.name(), dto.documentType(),
                dto.documentNumber(), dto.phoneNumber(), dto.licenseNumber(), dto.licenseType());

        RegisterDeliveryCommandResult result = deliveryUseCase.registerDelivery(cmd);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new RegisterDeliveryResponseDto(result.deliveryId(), result.distributorId(), result.message()));
    }

    @GetMapping
    public ResponseEntity<ListAllDeliveryResponseDto> listAllDeliveries(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "name") String sortBy,
            @RequestParam(required = false, defaultValue = "DESC") DirectionEnum direction) {
        RequestParams params = new RequestParams(page, size, sortBy, direction);
        ListAllDeliveryCommand cmd = new ListAllDeliveryCommand(params);
        ListAllDeliveryCommandResult result = deliveryUseCase.listAllDeliveries(cmd);

        return ResponseEntity.ok()
                .body(new ListAllDeliveryResponseDto(result.deliveries(), result.meta(), result.message()));
    }
}
