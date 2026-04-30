package com.tecno_comfenalco.pa.application.store.usecases;

import java.util.UUID;

import com.tecno_comfenalco.pa.application.store.command.actions.ListAllStoresCommand;
import com.tecno_comfenalco.pa.application.store.command.actions.RegisterStoreCommand;
import com.tecno_comfenalco.pa.application.store.command.response.GetStoreByIdCommandResult;
import com.tecno_comfenalco.pa.application.store.command.response.ListAllStoresCommandResult;
import com.tecno_comfenalco.pa.application.store.command.response.RegisterStoreCommandResult;

public interface StoreUseCase {
    RegisterStoreCommandResult registerStore(RegisterStoreCommand cmd);

    ListAllStoresCommandResult listAllStores(ListAllStoresCommand cmd);

    GetStoreByIdCommandResult getStoreById(UUID storeId);
}
