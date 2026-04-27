package com.tecno_comfenalco.pa.application.delivery.command.actions;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.vehicle.model.VehicleSummaryModel;
import com.tecno_comfenalco.pa.shared.enums.LicenseTypeEnum;

public record UpdateDeliveryCommand(UUID distributorId, UUID deliveryId, String name, Long phoneNumber,
        LicenseTypeEnum licenseTypeEnum, List<VehicleSummaryModel> vehicles) {

}
