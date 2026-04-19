package com.tecno_comfenalco.pa.features.presales.dto;

import com.tecno_comfenalco.pa.shared.enums.DocumentTypeEnum;

public record PresalesDto(String id, String name, String phoneNumber, String email, DocumentTypeEnum documentTypeEnum,
                Long documentNumber, String userId, String distributorId) {

}
