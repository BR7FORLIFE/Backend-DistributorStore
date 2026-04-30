package com.tecno_comfenalco.pa.application.store.orchestator;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tecno_comfenalco.pa.application.auth.Exceptions.UserNotFoundException;
import com.tecno_comfenalco.pa.application.auth.ports.IUserRepositoryPort;
import com.tecno_comfenalco.pa.application.store.command.actions.ListAllStoresCommand;
import com.tecno_comfenalco.pa.application.store.command.actions.RegisterStoreCommand;
import com.tecno_comfenalco.pa.application.store.command.response.GetStoreByIdCommandResult;
import com.tecno_comfenalco.pa.application.store.command.response.ListAllStoresCommandResult;
import com.tecno_comfenalco.pa.application.store.command.response.RegisterStoreCommandResult;
import com.tecno_comfenalco.pa.application.store.exceptions.StoreAlreadyExistsException;
import com.tecno_comfenalco.pa.application.store.exceptions.StoreNotFoundException;
import com.tecno_comfenalco.pa.application.store.ports.IStoreRepositoryPort;
import com.tecno_comfenalco.pa.application.store.usecases.StoreUseCase;
import com.tecno_comfenalco.pa.domain.auth.models.UserModel;
import com.tecno_comfenalco.pa.domain.store.models.StoreModel;
import com.tecno_comfenalco.pa.shared.utils.helper.ValidateQueryParams;
import com.tecno_comfenalco.pa.shared.utils.http.PagedResult;

@Service
public class StoreUseCaseImp implements StoreUseCase {

    private final IStoreRepositoryPort storeRepositoryPort;
    private final IUserRepositoryPort userRepositoryPort;

    public StoreUseCaseImp(IStoreRepositoryPort storeRepositoryPort, IUserRepositoryPort userRepositoryPort) {
        this.storeRepositoryPort = storeRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public RegisterStoreCommandResult registerStore(RegisterStoreCommand cmd) {
        // verificamos que no exista la tienda
        if (storeRepositoryPort.existsStoreByNit(cmd.nit())) {
            throw new StoreAlreadyExistsException();
        }

        Optional<UserModel> optUserModel = userRepositoryPort.findByUserId(cmd.userId());

        if (optUserModel.isEmpty()) {
            throw new UserNotFoundException();
        }

        StoreModel newStore = StoreModel.createDraft(cmd.userId(), cmd.name(), cmd.nit(), cmd.phoneNumber(),
                cmd.email(), cmd.direction(), Instant.now(), Instant.now());

        StoreModel saved = storeRepositoryPort.save(newStore);

        UserModel changeRolForUser = UserModel.createNew(saved.getUserId(), null, optUserModel.get().getUsername(),
                optUserModel.get().getPassword(), Set.of("STORE"), optUserModel.get().getEmail(),
                optUserModel.get().isEnabled());

        UserModel savedUser = userRepositoryPort.save(changeRolForUser);

        return new RegisterStoreCommandResult(saved.getId(), savedUser.getId(), "Store registered succesfull!");
    }

    @Override
    public ListAllStoresCommandResult listAllStores(ListAllStoresCommand cmd) {
        // validamos los query params
        ValidateQueryParams.validate(cmd.params());

        PagedResult<StoreModel> storesModels = storeRepositoryPort.findAllpaged(cmd.params().page(),
                cmd.params().size(), cmd.params().sortBy(), cmd.params().direction().name());

        return new ListAllStoresCommandResult(storesModels.data(), storesModels.meta(), "stores obtain succesfull!");
    }

    @Override
    public GetStoreByIdCommandResult getStoreById(UUID storeId) {
        Optional<StoreModel> optStore = storeRepositoryPort.findById(storeId);

        if (optStore.isEmpty()) {
            throw new StoreNotFoundException();
        }

        return new GetStoreByIdCommandResult(optStore.get(), "Store obtain succesfull!");
    }
}
