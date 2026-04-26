package com.tecno_comfenalco.pa.infrastructure.distributor.mapper;

import com.tecno_comfenalco.pa.domain.distributor.model.DistributorModel;
import com.tecno_comfenalco.pa.infrastructure.distributor.entity.DistributorDocument;

public class DistributorMapper {

    public static DistributorModel toDomain(DistributorDocument distributorDocument) {
        DistributorModel distributorModel = DistributorModel.createNew(distributorDocument.getId(),
                distributorDocument.getUserId(), distributorDocument.getNit(), distributorDocument.getName(),
                distributorDocument.getPhoneNumber(), distributorDocument.getEmail(),
                distributorDocument.getDirectionDto(), null); // necesito el mapper de vehicle para la lista

        return distributorModel;
    }

    public static DistributorDocument toEntity(DistributorModel distributorModel) {
        DistributorDocument distributorDocument = new DistributorDocument();
        distributorDocument.setId(distributorModel.getId());
        distributorDocument.setUserId(distributorModel.getUserId());
        distributorDocument.setNit(distributorModel.getNit());
        distributorDocument.setName(distributorModel.getName());
        distributorDocument.setPhoneNumber(distributorModel.getPhoneNumber());
        distributorDocument.setEmail(distributorModel.getEmail());
        distributorDocument.setDirectionDto(distributorModel.getDirectionDto());
        distributorDocument.setVehicleDocuments(null); // usar el mapper para la lista de vehiculos

        return distributorDocument;
    }
}
