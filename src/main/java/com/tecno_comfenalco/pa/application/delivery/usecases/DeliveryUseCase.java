package com.tecno_comfenalco.pa.application.delivery.usecases;

import com.tecno_comfenalco.pa.application.delivery.command.actions.ListAllDeliveryCommand;
import com.tecno_comfenalco.pa.application.delivery.command.actions.RegisterDeliveryCommand;
import com.tecno_comfenalco.pa.application.delivery.command.response.ListAllDeliveryCommandResult;
import com.tecno_comfenalco.pa.application.delivery.command.response.RegisterDeliveryCommandResult;

public interface DeliveryUseCase {
    RegisterDeliveryCommandResult registerDelivery(RegisterDeliveryCommand cmd);

    ListAllDeliveryCommandResult listAllDeliveries(ListAllDeliveryCommand cmd);
}
