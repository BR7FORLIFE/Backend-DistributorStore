package com.tecno_comfenalco.pa.infrastructure.delivery.entity;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import com.tecno_comfenalco.pa.infrastructure.vehicle.entity.VehicleSummaryDocument;
import com.tecno_comfenalco.pa.shared.enums.DocumentTypeEnum;
import com.tecno_comfenalco.pa.shared.enums.LicenseTypeEnum;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "delivery")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryDocument {
    @Id
    private UUID id;
    private UUID distributorId;
    private String name;
    private DocumentTypeEnum documentType;
    private Long documentNumber;
    private Long phoneNumber;
    private Long licenseNumber;
    private LicenseTypeEnum licenseType;
    private List<VehicleSummaryDocument> vehicles;
    private Instant createAt;
    private Instant updateAt;
}
