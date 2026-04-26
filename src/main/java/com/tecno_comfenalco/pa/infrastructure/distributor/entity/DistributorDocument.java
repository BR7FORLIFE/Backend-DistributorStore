package com.tecno_comfenalco.pa.infrastructure.distributor.entity;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tecno_comfenalco.pa.infrastructure.vehicle.entity.VehicleDocument;
import com.tecno_comfenalco.pa.shared.dto.DirectionDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "distributor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DistributorDocument {
    @Id
    private UUID id;
    private UUID userId;
    private String nit;
    private String name;
    private Long phoneNumber;
    private String email;
    private DirectionDto directionDto;
    private List<VehicleDocument> vehicleDocuments;
}
