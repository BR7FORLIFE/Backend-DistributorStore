package com.tecno_comfenalco.pa.application.store.usecases;

import com.tecno_comfenalco.pa.application.store.command.storeBinding.actions.SendBindingCommand;
import com.tecno_comfenalco.pa.application.store.command.storeBinding.response.SendBindingCommandResult;

public interface StoreBindingUseCase {

    SendBindingCommandResult sendBindingStoreRequest(SendBindingCommand cmd);
}
