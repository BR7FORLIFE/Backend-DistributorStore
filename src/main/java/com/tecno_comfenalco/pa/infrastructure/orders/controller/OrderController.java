package com.tecno_comfenalco.pa.infrastructure.orders.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecno_comfenalco.pa.application.auth.Exceptions.UserNotFoundException;
import com.tecno_comfenalco.pa.application.orders.command.actions.CreateOrderCommand;
import com.tecno_comfenalco.pa.application.orders.command.response.CreateOrderCommandResult;
import com.tecno_comfenalco.pa.application.orders.dto.request.CreateOrderRequestDto;
import com.tecno_comfenalco.pa.application.orders.dto.response.CreateOrderResponseDto;
import com.tecno_comfenalco.pa.application.orders.usecases.OrderUsecase;
import com.tecno_comfenalco.pa.infrastructure.security.CustomUserDetails;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderUsecase orderUsecase;

    public OrderController(OrderUsecase orderUsecase) {
        this.orderUsecase = orderUsecase;
    }

    @PreAuthorize("hasAnyRole('PRESALES', 'STORE')")
    @PostMapping
    public ResponseEntity<CreateOrderResponseDto> createOrder(
            @RequestBody @Valid CreateOrderRequestDto dto,
            Authentication authentication) {
        CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();

        String role = details.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException());

        CreateOrderCommand cmd = new CreateOrderCommand(
                details.getUserId(),
                dto.distributorId(),
                role,
                dto.storeId(),
                dto.products());

        CreateOrderCommandResult result = orderUsecase.createOrder(cmd);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateOrderResponseDto(
                result.orderId(),
                result.numberOrder(),
                result.distributorId(),
                result.storeId(),
                result.statusOrder(),
                result.expiration(),
                result.message()));
    }
}
