package com.tecno_comfenalco.pa.application.store.orchestator;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tecno_comfenalco.pa.application.distributor.exceptions.DistributorNotFoundException;
import com.tecno_comfenalco.pa.application.distributor.ports.IDistributorRepositoryPort;
import com.tecno_comfenalco.pa.application.presales.exceptions.PresalesNotFoundException;
import com.tecno_comfenalco.pa.application.presales.ports.IPresalesRepositoryPort;
import com.tecno_comfenalco.pa.application.store.command.storeBinding.actions.ChangeStatusBindingCommand;
import com.tecno_comfenalco.pa.application.store.command.storeBinding.actions.ListAllBindingCommand;
import com.tecno_comfenalco.pa.application.store.command.storeBinding.actions.SendBindingCommand;
import com.tecno_comfenalco.pa.application.store.command.storeBinding.response.ChangeStatusBindingCommandResult;
import com.tecno_comfenalco.pa.application.store.command.storeBinding.response.ListAllBindingCommandResult;
import com.tecno_comfenalco.pa.application.store.command.storeBinding.response.SendBindingCommandResult;
import com.tecno_comfenalco.pa.application.store.exceptions.StoreBindingAlreadyExistsException;
import com.tecno_comfenalco.pa.application.store.exceptions.StoreBindingNotFoundException;
import com.tecno_comfenalco.pa.application.store.exceptions.StoreNotFoundException;
import com.tecno_comfenalco.pa.application.store.ports.IStoreBindingRepositoryPort;
import com.tecno_comfenalco.pa.application.store.ports.IStoreRepositoryPort;
import com.tecno_comfenalco.pa.application.store.usecases.StoreBindingUseCase;
import com.tecno_comfenalco.pa.config.GenerateCodeService;
import com.tecno_comfenalco.pa.domain.presales.model.PresalesModel;
import com.tecno_comfenalco.pa.domain.store.models.StoreBindingRequestModel;
import com.tecno_comfenalco.pa.domain.store.services.ValidationBindingRequest;
import com.tecno_comfenalco.pa.shared.utils.helper.ValidateQueryParams;
import com.tecno_comfenalco.pa.shared.utils.http.PagedResult;

@Service
public class StoreBindingUseCaseImp implements StoreBindingUseCase {

    private final IDistributorRepositoryPort distributorRepositoryPort;
    private final IStoreRepositoryPort storeRepositoryPort;
    private final IStoreBindingRepositoryPort iStoreBindingRepositoryPort;
    private final IPresalesRepositoryPort presalesRepositoryPort;
    private final GenerateCodeService generateCodeService; // generador aleatorio con entropia

    public StoreBindingUseCaseImp(IStoreRepositoryPort storeRepositoryPort,
            IStoreBindingRepositoryPort iStoreBindingRepositoryPort,
            IPresalesRepositoryPort presalesRepositoryPort,
            IDistributorRepositoryPort distributorRepositoryPort,
            GenerateCodeService generateCodeService) {
        this.iStoreBindingRepositoryPort = iStoreBindingRepositoryPort;
        this.presalesRepositoryPort = presalesRepositoryPort;
        this.storeRepositoryPort = storeRepositoryPort;
        this.distributorRepositoryPort = distributorRepositoryPort;
        this.generateCodeService = generateCodeService;
    }

    @Override
    public SendBindingCommandResult sendBindingStoreRequest(SendBindingCommand cmd) {
        // verifcamos que exista la tienda legalmente en la plataforma y en la vida real
        if (!storeRepositoryPort.existsStoreByNit(cmd.nit())) {
            throw new StoreNotFoundException();
        }

        // verificamos que no haya existido un binding request anterior
        if (iStoreBindingRepositoryPort.existsStoreBindingByNitAndDistributorId(cmd.nit(), cmd.distributorId())) {
            throw new StoreBindingAlreadyExistsException();
        }

        // obtenemos el presales vinculado al userId
        Optional<PresalesModel> optPresales = presalesRepositoryPort
                .findPresalesByUserIdAndDistributorId(cmd.userPresalesId(), cmd.distributorId());

        if (optPresales.isEmpty()) {
            throw new PresalesNotFoundException();
        }

        StoreBindingRequestModel requestBinding = StoreBindingRequestModel.createDraft(optPresales.get().getId(),
                optPresales.get().getDistributorId(), cmd.nit(), cmd.tempName(), null);

        StoreBindingRequestModel saved = iStoreBindingRepositoryPort.save(requestBinding);

        return new SendBindingCommandResult(saved.getId(), saved.getDistributorId(), saved.getBindingStatus(),
                saved.getCreateAt(), "binding request created succesfull!");
    }

    @Override
    public ListAllBindingCommandResult listAllBindings(ListAllBindingCommand cmd) {
        // verificamos que es verdad que exista la distribuidora
        if (!distributorRepositoryPort.existsDistributorById(cmd.distributorId())) {
            throw new DistributorNotFoundException();
        }

        ValidateQueryParams.validate(cmd.params()); // validamos los query params

        PagedResult<StoreBindingRequestModel> bindingsModels = iStoreBindingRepositoryPort.findAllPaged(
                cmd.distributorId(),
                cmd.params().name(),
                cmd.params().page(),
                cmd.params().size(),
                cmd.params().sortBy(),
                cmd.params().direction().name());

        return new ListAllBindingCommandResult(bindingsModels.data(), bindingsModels.meta(),
                "bindings obtain succesfull!");
    }

    // flujo de cambio de estado del request binding por parte de la distribuidora
    @Override
    public ChangeStatusBindingCommandResult changeStatusBindingByDistributor(ChangeStatusBindingCommand cmd) {
        Optional<StoreBindingRequestModel> optBinding = iStoreBindingRepositoryPort.findById(cmd.bindingId());

        if (optBinding.isEmpty()) {
            throw new StoreBindingNotFoundException();
        }

        String code = generateCodeService.randomBase64(256);

        StoreBindingRequestModel newBinding = ValidationBindingRequest.validateTransitionState(optBinding.get(),
                cmd.bindingStatus(), code,true);

        StoreBindingRequestModel updateBinding = iStoreBindingRepositoryPort.save(newBinding);

        return new ChangeStatusBindingCommandResult(updateBinding.getId(), updateBinding.getBindingStatus(),
                "binding update status succesfull! wait to STORE aceptation!");
    }

    // flujo de aceptacion del request binding por parte de la tienda

}
