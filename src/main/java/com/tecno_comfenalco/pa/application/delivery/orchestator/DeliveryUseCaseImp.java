package com.tecno_comfenalco.pa.application.delivery.orchestator;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tecno_comfenalco.pa.application.delivery.command.actions.GetDeliveryByIdCommand;
import com.tecno_comfenalco.pa.application.delivery.command.actions.ListAllDeliveryCommand;
import com.tecno_comfenalco.pa.application.delivery.command.actions.RegisterDeliveryCommand;
import com.tecno_comfenalco.pa.application.delivery.command.actions.UpdateDeliveryCommand;
import com.tecno_comfenalco.pa.application.delivery.command.response.GetDeliveryByIdCommandResult;
import com.tecno_comfenalco.pa.application.delivery.command.response.ListAllDeliveryCommandResult;
import com.tecno_comfenalco.pa.application.delivery.command.response.RegisterDeliveryCommandResult;
import com.tecno_comfenalco.pa.application.delivery.command.response.UpdateDeliveryCommandResult;
import com.tecno_comfenalco.pa.application.delivery.exceptions.DeliveryAlreadyExistsException;
import com.tecno_comfenalco.pa.application.delivery.exceptions.DeliveryNotFoundException;
import com.tecno_comfenalco.pa.application.delivery.ports.IDeliveryRepositoryPort;
import com.tecno_comfenalco.pa.application.delivery.usecases.DeliveryUseCase;
import com.tecno_comfenalco.pa.domain.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.domain.vehicle.model.VehicleSummaryModel;
import com.tecno_comfenalco.pa.shared.utils.helper.ValidateQueryParams;
import com.tecno_comfenalco.pa.shared.utils.http.PagedResult;
import com.tecno_comfenalco.pa.shared.utils.http.RequestParams;

@Service
public class DeliveryUseCaseImp implements DeliveryUseCase {

    private final IDeliveryRepositoryPort deliveryRepositoryPort;

    public DeliveryUseCaseImp(IDeliveryRepositoryPort iDeliveryRepositoryPort) {
        this.deliveryRepositoryPort = iDeliveryRepositoryPort;
    }

    @Override
    public RegisterDeliveryCommandResult registerDelivery(RegisterDeliveryCommand cmd) {
        if (deliveryRepositoryPort.existsByDocumentNumber(cmd.documentNumber())) {
            throw new DeliveryAlreadyExistsException();
        }

        List<VehicleSummaryModel> vehicles = cmd.vehicles() == null
                ? List.of()
                : cmd.vehicles();

        DeliveryModel newDelivery = DeliveryModel.createDraft(cmd.distributorId(), cmd.name(), cmd.documentTypeEnum(),
                cmd.documentNumber(), cmd.phoneNumber(), cmd.licenseNumber(), cmd.licenseTypeEnum(), vehicles);

        DeliveryModel saved = deliveryRepositoryPort.save(newDelivery);

        return new RegisterDeliveryCommandResult(saved.getDistributorId(), saved.getId(),
                "Delivery register succesfull!");
    }

    @Override
    public ListAllDeliveryCommandResult listAllDeliveries(ListAllDeliveryCommand cmd) {
        ValidateQueryParams.validate(cmd.params());

        PagedResult<DeliveryModel> deliveries = deliveryRepositoryPort.findAllPaged(cmd.distributorId(),
                cmd.params().page(), cmd.params().size(), cmd.params().sortBy(), cmd.params().direction().name());

        return new ListAllDeliveryCommandResult(deliveries.data(), deliveries.meta(), "Deliveries obtain succesfull!");
    }

    @Override
    public GetDeliveryByIdCommandResult getDeliveryById(GetDeliveryByIdCommand cmd) {
        Optional<DeliveryModel> optDelivery = deliveryRepositoryPort.findByIdAndDistributorId(cmd.deliveryId(),
                cmd.distributorId());

        if (optDelivery.isEmpty()) {
            throw new DeliveryNotFoundException();
        }

        return new GetDeliveryByIdCommandResult(optDelivery.get(), "Delivery obtain succesfull!");
    }

    @Override
    public UpdateDeliveryCommandResult updateDelivery(UpdateDeliveryCommand cmd) {
        Optional<DeliveryModel> optDelivery = deliveryRepositoryPort.findByIdAndDistributorId(cmd.deliveryId(),
                cmd.distributorId());

        if (optDelivery.isEmpty()) {
            throw new DeliveryNotFoundException();
        }

        DeliveryModel updateDelivery = DeliveryModel.createNew(optDelivery.get().getId(),
                optDelivery.get().getDistributorId(), cmd.name(), optDelivery.get().getDocumentType(),
                optDelivery.get().getDocumentNumber(), cmd.phoneNumber(), optDelivery.get().getLicenseNumber(),
                cmd.licenseTypeEnum(), cmd.vehicles(), optDelivery.get().getCreateAt(), Instant.now());

        DeliveryModel result = deliveryRepositoryPort.save(updateDelivery);

        return new UpdateDeliveryCommandResult(result.getId(), "delivery update succesfull!");
    }
}
