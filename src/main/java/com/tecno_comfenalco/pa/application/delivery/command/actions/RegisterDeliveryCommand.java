package com.tecno_comfenalco.pa.application.delivery.command.actions;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.vehicle.model.VehicleSummaryModel;
import com.tecno_comfenalco.pa.shared.enums.DocumentTypeEnum;
import com.tecno_comfenalco.pa.shared.enums.LicenseTypeEnum;

public record RegisterDeliveryCommand(UUID userDistributorId, String username, String password, String email, String name,
        DocumentTypeEnum documentTypeEnum,
        Long documentNumber, Long phoneNumber, Long licenseNumber, LicenseTypeEnum licenseTypeEnum,
        List<VehicleSummaryModel> vehicles) {

}
