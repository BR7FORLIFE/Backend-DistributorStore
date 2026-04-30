package com.tecno_comfenalco.pa.application.store.orchestator;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tecno_comfenalco.pa.application.presales.ports.IPresalesRepositoryPort;
import com.tecno_comfenalco.pa.application.store.command.storeBinding.actions.SendBindingCommand;
import com.tecno_comfenalco.pa.application.store.command.storeBinding.response.SendBindingCommandResult;
import com.tecno_comfenalco.pa.application.store.ports.IStoreBindingRepositoryPort;
import com.tecno_comfenalco.pa.application.store.usecases.StoreBindingUseCase;
import com.tecno_comfenalco.pa.domain.presales.model.PresalesModel;

@Service
public class StoreBindingUseCaseImp implements StoreBindingUseCase {

    private final IStoreBindingRepositoryPort iStoreBindingRepositoryPort;
    private final IPresalesRepositoryPort presalesRepositoryPort;

    public StoreBindingUseCaseImp(IStoreBindingRepositoryPort iStoreBindingRepositoryPort,
            IPresalesRepositoryPort presalesRepositoryPort) {
        this.iStoreBindingRepositoryPort = iStoreBindingRepositoryPort;
        this.presalesRepositoryPort = presalesRepositoryPort;
    }

    @Override
    public SendBindingCommandResult sendBindingStoreRequest(SendBindingCommand cmd) {
        //obtenemos el presales vinculado al userId
        //Optional<PresalesModel> optPresales = presalesRepositoryPort.

        return null;
    }
}
