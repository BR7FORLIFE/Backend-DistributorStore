package com.tecno_comfenalco.pa.infrastructure.presales.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecno_comfenalco.pa.application.presales.command.actions.EditPresalesCommand;
import com.tecno_comfenalco.pa.application.presales.command.actions.GetPresalesInfoCommand;
import com.tecno_comfenalco.pa.application.presales.command.actions.ListPresalesCommand;
import com.tecno_comfenalco.pa.application.presales.command.actions.RegisterPresalesCommand;
import com.tecno_comfenalco.pa.application.presales.command.response.EditPresalesCommandResult;
import com.tecno_comfenalco.pa.application.presales.command.response.GetPresalesByIdCommandResult;
import com.tecno_comfenalco.pa.application.presales.command.response.GetPresalesInfoCommandResult;
import com.tecno_comfenalco.pa.application.presales.command.response.ListPresalesCommandResult;
import com.tecno_comfenalco.pa.application.presales.command.response.RegisterPresalesCommandResult;
import com.tecno_comfenalco.pa.application.presales.dto.request.EditPresalesRequestDto;
import com.tecno_comfenalco.pa.application.presales.dto.request.RegisterPresalesRequestDto;
import com.tecno_comfenalco.pa.application.presales.dto.response.EditPresalesResponseDto;
import com.tecno_comfenalco.pa.application.presales.dto.response.GetPresaleInfoResponseDto;
import com.tecno_comfenalco.pa.application.presales.dto.response.GetPresalesByIdResponseDto;
import com.tecno_comfenalco.pa.application.presales.dto.response.ListPresalesResponseDto;
import com.tecno_comfenalco.pa.application.presales.dto.response.RegisterPresalesResponseDto;
import com.tecno_comfenalco.pa.application.presales.usecases.PresalesUseCase;
import com.tecno_comfenalco.pa.infrastructure.security.CustomUserDetails;
import com.tecno_comfenalco.pa.shared.utils.http.DirectionEnum;
import com.tecno_comfenalco.pa.shared.utils.http.RequestParams;

import jakarta.validation.Valid;

@PreAuthorize("hasRole('DISTRIBUTOR')")
@RestController
@RequestMapping("/presales")
public class PresalesController {

    private final PresalesUseCase presalesUseCase;

    public PresalesController(PresalesUseCase presalesUseCase) {
        this.presalesUseCase = presalesUseCase;
    }

    @PostMapping
    public ResponseEntity<RegisterPresalesResponseDto> newPresales(
            @RequestBody @Valid RegisterPresalesRequestDto dtoPresales, Authentication authentication) {

        CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();

        RegisterPresalesCommand cmd = new RegisterPresalesCommand(details.getUserId(), dtoPresales.name(),
                dtoPresales.phoneNumber(),
                dtoPresales.email(), dtoPresales.documentType(), dtoPresales.documentNumber());

        RegisterPresalesCommandResult result = presalesUseCase.registerPresales(cmd);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new RegisterPresalesResponseDto(result.presalesId(), result.distributorId(), result.message()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditPresalesResponseDto> editPresales(@PathVariable UUID id,
            @RequestBody @Valid EditPresalesRequestDto dtoPresales, Authentication authentication) {
        CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();

        EditPresalesCommand cmd = new EditPresalesCommand(details.getUserId(), id, dtoPresales.name(),
                dtoPresales.phoneNumber());

        EditPresalesCommandResult result = presalesUseCase.editPresales(cmd);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new EditPresalesResponseDto(result.distributorId(), result.presalesId(), result.message()));
    }

    @GetMapping
    public ResponseEntity<ListPresalesResponseDto> listPresales(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "name") String sortBy,
            @RequestParam(required = false, defaultValue = "DESC") DirectionEnum direction,
            Authentication authentication) {
        CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();

        RequestParams params = new RequestParams(page, size, sortBy, direction);
        ListPresalesCommand cmd = new ListPresalesCommand(details.getUserId(), params);

        ListPresalesCommandResult result = presalesUseCase.listPresales(cmd);

        return ResponseEntity.ok()
                .body(new ListPresalesResponseDto(result.presalesModels(), result.meta(), result.message()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPresalesByIdResponseDto> showPresales(@PathVariable UUID id,
            Authentication authentication) {
        CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();
        GetPresalesByIdCommandResult result = presalesUseCase.showPresales(details.getUserId(), id);

        return ResponseEntity.ok().body(new GetPresalesByIdResponseDto(result.presales(), result.message()));
    }

    @PreAuthorize("hasRole('PRESALES')")
    @GetMapping("/{distributorId}/info")
    public ResponseEntity<GetPresaleInfoResponseDto> getAuthenticatedPresalesId(@PathVariable UUID distributorId,
            Authentication authentication) {
        CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();
        GetPresalesInfoCommand cmd = new GetPresalesInfoCommand(details.getUserId(), distributorId);

        GetPresalesInfoCommandResult result = presalesUseCase.getPresalesInfo(cmd);

        return ResponseEntity.ok().body(new GetPresaleInfoResponseDto(result.presale(), result.message()));
    }
}
