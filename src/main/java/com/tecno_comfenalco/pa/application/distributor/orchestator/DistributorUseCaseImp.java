package com.tecno_comfenalco.pa.application.distributor.orchestator;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tecno_comfenalco.pa.application.distributor.command.actions.EditDistributorCommand;
import com.tecno_comfenalco.pa.application.distributor.command.actions.ListAllDistributorsCommand;
import com.tecno_comfenalco.pa.application.distributor.command.actions.RegisterDistributorCommand;
import com.tecno_comfenalco.pa.application.distributor.command.response.EditDistributorCommandResult;
import com.tecno_comfenalco.pa.application.distributor.command.response.GetDistributorByIdCommandResult;
import com.tecno_comfenalco.pa.application.distributor.command.response.GetDistributorByNITCommandResult;
import com.tecno_comfenalco.pa.application.distributor.command.response.ListAllDistributorsCommandResult;
import com.tecno_comfenalco.pa.application.distributor.command.response.RegisterDistributorCommandResult;
import com.tecno_comfenalco.pa.application.distributor.exceptions.DistributorAlreadyExists;
import com.tecno_comfenalco.pa.application.distributor.exceptions.DistributorNotFoundException;
import com.tecno_comfenalco.pa.application.distributor.ports.IDistributorRepositoryPort;
import com.tecno_comfenalco.pa.application.distributor.usecase.DistributorUseCase;
import com.tecno_comfenalco.pa.domain.distributor.model.DistributorModel;
import com.tecno_comfenalco.pa.shared.utils.helper.ValidateQueryParams;
import com.tecno_comfenalco.pa.shared.utils.http.PagedResult;

@Service
public class DistributorUseCaseImp implements DistributorUseCase {

    private final IDistributorRepositoryPort distributorRepositoryPort;

    public DistributorUseCaseImp(IDistributorRepositoryPort iDistributorRepositoryPort) {
        this.distributorRepositoryPort = iDistributorRepositoryPort;
    }

    @Override
    public RegisterDistributorCommandResult registerDistributor(RegisterDistributorCommand cmd) {

        // validamos que no exista un NIT asociadd
        if (distributorRepositoryPort.existsDistributorByNit(cmd.nit())) {
            throw new DistributorAlreadyExists();
        }

        // validamos que no exista un email asociado
        if (distributorRepositoryPort.existsDistributorByEmail(cmd.email())) {
            throw new DistributorAlreadyExists();
        }

        DistributorModel newDistributorModel = DistributorModel.createDraft(cmd.userId(), cmd.nit(), cmd.name(),
                cmd.phoneNumber(), cmd.email(), cmd.directionDto(), List.of());

        DistributorModel result = distributorRepositoryPort.save(newDistributorModel);

        return new RegisterDistributorCommandResult(result.getId(), result.getUserId(),
                "Distributor created succesfull!");
    }

    @Override
    public ListAllDistributorsCommandResult listAllDistributors(ListAllDistributorsCommand cmd) {
        // Validar los queryparams
        ValidateQueryParams.validate(cmd.params());

        PagedResult<DistributorModel> distributorModels = distributorRepositoryPort.findAllPaged(cmd.params().page(),
                cmd.params().size(),
                cmd.params().sortBy(), cmd.params().direction().name());

        return new ListAllDistributorsCommandResult(distributorModels.data(), distributorModels.meta(),
                "Distributors obtain succesfull!");
    }

    @Override
    public GetDistributorByIdCommandResult getDistributorById(UUID distributorId) {
        Optional<DistributorModel> optDistributor = distributorRepositoryPort.findById(distributorId);

        if (optDistributor.isEmpty()) {
            throw new DistributorNotFoundException();
        }

        return new GetDistributorByIdCommandResult(optDistributor.get(), "distributor obtain succesfull");
    }

    @Override
    public GetDistributorByNITCommandResult getDistributorByNIT(String NIT) {
        Optional<DistributorModel> optDistributor = distributorRepositoryPort.findByNIT(NIT);

        if (optDistributor.isEmpty()) {
            throw new DistributorNotFoundException();
        }

        return new GetDistributorByNITCommandResult(optDistributor.get(), "distributor obtain succesfull!");
    }

    @Override
    public EditDistributorCommandResult editDistributor(EditDistributorCommand cmd) {

        Optional<DistributorModel> optDistributorModel = distributorRepositoryPort.findById(cmd.distributorId());

        if (optDistributorModel.isEmpty()) {
            throw new DistributorNotFoundException();
        }

        DistributorModel updateDistributor = DistributorModel.createNew(cmd.distributorId(),
                optDistributorModel.get().getUserId(), optDistributorModel.get().getNit(), cmd.name(),
                cmd.phoneNumber(), optDistributorModel.get().getEmail(), optDistributorModel.get().getCreateAt(),
                Instant.now(), cmd.direction(),
                optDistributorModel.get().getVehicles());

        distributorRepositoryPort.save(updateDistributor);

        return new EditDistributorCommandResult("Distributor update succesfull!");
    }
}
