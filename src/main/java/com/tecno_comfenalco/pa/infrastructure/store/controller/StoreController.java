package com.tecno_comfenalco.pa.infrastructure.store.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecno_comfenalco.pa.application.store.command.actions.ListAllStoresCommand;
import com.tecno_comfenalco.pa.application.store.command.actions.RegisterStoreCommand;
import com.tecno_comfenalco.pa.application.store.command.actions.UpdateStoreCommand;
import com.tecno_comfenalco.pa.application.store.command.response.DisabledStoreCommandResult;
import com.tecno_comfenalco.pa.application.store.command.response.GetStoreByIdCommandResult;
import com.tecno_comfenalco.pa.application.store.command.response.ListAllStoresCommandResult;
import com.tecno_comfenalco.pa.application.store.command.response.RegisterStoreCommandResult;
import com.tecno_comfenalco.pa.application.store.command.response.UpdateStoreCommandResult;
import com.tecno_comfenalco.pa.application.store.dto.request.RegisterStoreRequestDto;
import com.tecno_comfenalco.pa.application.store.dto.request.UpdateStoreRequestDto;
import com.tecno_comfenalco.pa.application.store.dto.response.DisabledStoreByIdResponseDto;
import com.tecno_comfenalco.pa.application.store.dto.response.GetStoreyByIdResponseDto;
import com.tecno_comfenalco.pa.application.store.dto.response.ListAllStoresResponseDto;
import com.tecno_comfenalco.pa.application.store.dto.response.RegisterStoreResponseDto;
import com.tecno_comfenalco.pa.application.store.dto.response.UpdateStoreResponseDto;
import com.tecno_comfenalco.pa.application.store.usecases.StoreUseCase;
import com.tecno_comfenalco.pa.shared.utils.http.DirectionEnum;
import com.tecno_comfenalco.pa.shared.utils.http.RequestParams;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreUseCase storeUseCase;

    public StoreController(StoreUseCase storeUseCase) {
        this.storeUseCase = storeUseCase;
    }

    @PostMapping
    public ResponseEntity<RegisterStoreResponseDto> registerStore(@RequestBody RegisterStoreRequestDto dto) {
        RegisterStoreCommand cmd = new RegisterStoreCommand(dto.userId(), dto.name(), dto.nit(), dto.phoneNumber(),
                dto.email(), dto.direction());

        RegisterStoreCommandResult result = storeUseCase.registerStore(cmd);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new RegisterStoreResponseDto(result.storeId(), result.userId(), result.message()));
    }

    @GetMapping
    public ResponseEntity<ListAllStoresResponseDto> listAllStores(
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "name") String sortBy,
            @RequestParam(required = false, defaultValue = "DESC") DirectionEnum direction) {
        RequestParams params = new RequestParams(name, page, size, sortBy, direction);
        ListAllStoresCommand cmd = new ListAllStoresCommand(params);
        ListAllStoresCommandResult result = storeUseCase.listAllStores(cmd);

        return ResponseEntity.ok()
                .body(new ListAllStoresResponseDto(result.stores(), result.meta(), result.message()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetStoreyByIdResponseDto> getStoreById(@PathVariable UUID id) {
        GetStoreByIdCommandResult result = storeUseCase.getStoreById(id);
        return ResponseEntity.ok().body(new GetStoreyByIdResponseDto(result.store(), result.message()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateStoreResponseDto> updateStore(@PathVariable UUID id,
            @RequestBody UpdateStoreRequestDto dto) {

        UpdateStoreCommand cmd = new UpdateStoreCommand(id, dto.name(), dto.phoneNumber(), dto.direction());
        UpdateStoreCommandResult result = storeUseCase.updateStore(cmd);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new UpdateStoreResponseDto(result.storeId(), result.message()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DisabledStoreByIdResponseDto> disabledStore(UUID id) {
        DisabledStoreCommandResult result = storeUseCase.disabledStore(id);
        return ResponseEntity.ok().body(new DisabledStoreByIdResponseDto(result.userId(), result.message()));
    }

    @PreAuthorize("hasRole('STORE')")
    @GetMapping("/verify-binding")
    public ResponseEntity<?> acceptBindingByDistributor(
            @RequestParam(required = true) String token,
            Authentication authentication) {
        return null;
    }
}
