package com.tecno_comfenalco.pa.application.delivery.dto.request;

import java.util.List;

import com.tecno_comfenalco.pa.domain.vehicle.model.VehicleSummaryModel;
import com.tecno_comfenalco.pa.shared.enums.LicenseTypeEnum;

public record UpdateDeliveryRequestDto(String name, Long phoneNumber, LicenseTypeEnum licenseType,
        List<VehicleSummaryModel> vehicles) {

}
