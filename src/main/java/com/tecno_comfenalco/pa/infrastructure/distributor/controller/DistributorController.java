package com.tecno_comfenalco.pa.infrastructure.distributor.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecno_comfenalco.pa.application.distributor.command.actions.EditDistributorCommand;
import com.tecno_comfenalco.pa.application.distributor.command.actions.ListAllDistributorsCommand;
import com.tecno_comfenalco.pa.application.distributor.command.actions.RegisterDistributorCommand;
import com.tecno_comfenalco.pa.application.distributor.command.response.EditDistributorCommandResult;
import com.tecno_comfenalco.pa.application.distributor.command.response.GetDistributorByIdCommandResult;
import com.tecno_comfenalco.pa.application.distributor.command.response.GetDistributorByNITCommandResult;
import com.tecno_comfenalco.pa.application.distributor.command.response.ListAllDistributorsCommandResult;
import com.tecno_comfenalco.pa.application.distributor.command.response.RegisterDistributorCommandResult;
import com.tecno_comfenalco.pa.application.distributor.dto.request.EditDistributorRequestDto;
import com.tecno_comfenalco.pa.application.distributor.dto.request.RegisterDistributorRequestDto;
import com.tecno_comfenalco.pa.application.distributor.dto.response.EditDistributorResponseDto;
import com.tecno_comfenalco.pa.application.distributor.dto.response.GetDistributorResponseDto;
import com.tecno_comfenalco.pa.application.distributor.dto.response.ListDistributorResponseDto;
import com.tecno_comfenalco.pa.application.distributor.dto.response.RegisterDistributorResponseDto;
import com.tecno_comfenalco.pa.application.distributor.usecase.DistributorUseCase;
import com.tecno_comfenalco.pa.shared.utils.http.DirectionEnum;
import com.tecno_comfenalco.pa.shared.utils.http.RequestParams;

import jakarta.validation.Valid;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("distributor")
public class DistributorController {

    private final DistributorUseCase distributorUseCase;

    public DistributorController(DistributorUseCase distributorUseCase) {
        this.distributorUseCase = distributorUseCase;
    }

    @PostMapping
    public ResponseEntity<RegisterDistributorResponseDto> newDistributor(
            @RequestBody @Valid RegisterDistributorRequestDto dtoDistributor) {
        RegisterDistributorCommand cmd = new RegisterDistributorCommand(dtoDistributor.userId(), dtoDistributor.NIT(),
                dtoDistributor.name(), dtoDistributor.phoneNumber(), dtoDistributor.email(),
                dtoDistributor.direction());

        RegisterDistributorCommandResult result = distributorUseCase.registerDistributor(cmd);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new RegisterDistributorResponseDto(result.distributorId(), result.userId(), result.message()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditDistributorResponseDto> editDistributor(@PathVariable UUID id,
            @RequestBody @Valid EditDistributorRequestDto dtoDistributor) {
        EditDistributorCommand cmd = new EditDistributorCommand(id, dtoDistributor.name(), dtoDistributor.phoneNumber(),
                dtoDistributor.direction());

        EditDistributorCommandResult result = distributorUseCase.editDistributor(cmd);

        return ResponseEntity.status(HttpStatus.CREATED).body(new EditDistributorResponseDto(result.message()));
    }

    @GetMapping
    public ResponseEntity<ListDistributorResponseDto> listDistributors(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "name") String sortBy,
            @RequestParam(required = false, defaultValue = "DESC") DirectionEnum direction) {

        RequestParams params = new RequestParams(page, size, sortBy, direction);
        ListAllDistributorsCommand cmd = new ListAllDistributorsCommand(params);

        ListAllDistributorsCommandResult result = distributorUseCase.listAllDistributors(cmd);

        return ResponseEntity.ok()
                .body(new ListDistributorResponseDto(result.distributors(), result.meta(), result.message()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetDistributorResponseDto> showDistributor(@PathVariable UUID id) {
        GetDistributorByIdCommandResult result = distributorUseCase.getDistributorById(id);
        return ResponseEntity.ok().body(new GetDistributorResponseDto(result.distributor(), result.message()));
    }

    @GetMapping("/nit/{NIT}")
    public ResponseEntity<GetDistributorResponseDto> showDistributorByNIT(@PathVariable String NIT) {
        GetDistributorByNITCommandResult result = distributorUseCase.getDistributorByNIT(NIT);
        return ResponseEntity.ok().body(new GetDistributorResponseDto(result.distributor(), result.message()));
    }
}
