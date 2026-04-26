package com.tecno_comfenalco.pa.application.delivery.orchestator;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tecno_comfenalco.pa.application.delivery.command.actions.ListAllDeliveryCommand;
import com.tecno_comfenalco.pa.application.delivery.command.actions.RegisterDeliveryCommand;
import com.tecno_comfenalco.pa.application.delivery.command.response.ListAllDeliveryCommandResult;
import com.tecno_comfenalco.pa.application.delivery.command.response.RegisterDeliveryCommandResult;
import com.tecno_comfenalco.pa.application.delivery.exceptions.DeliveryAlreadyExistsException;
import com.tecno_comfenalco.pa.application.delivery.ports.IDeliveryRepositoryPort;
import com.tecno_comfenalco.pa.application.delivery.usecases.DeliveryUseCase;
import com.tecno_comfenalco.pa.domain.delivery.model.DeliveryModel;

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

        DeliveryModel newDelivery = DeliveryModel.createDraft(cmd.distributorId(), cmd.name(), cmd.documentTypeEnum(),
                cmd.documentNumber(), cmd.phoneNumber(), cmd.licenseNumber(), cmd.licenseTypeEnum(), List.of());

        DeliveryModel saved = deliveryRepositoryPort.save(newDelivery);

        return new RegisterDeliveryCommandResult(saved.getDistributorId(), saved.getId(),
                "Delivery register succesfull!");
    }

    @Override
    public ListAllDeliveryCommandResult listAllDeliveries(ListAllDeliveryCommand cmd) {
        return null;
    }
}
