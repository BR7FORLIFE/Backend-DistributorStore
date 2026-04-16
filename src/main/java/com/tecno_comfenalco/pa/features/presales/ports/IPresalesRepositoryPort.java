package com.tecno_comfenalco.pa.features.presales.ports;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.features.presales.models.PresalesModel;

public interface IPresalesRepositoryPort {

    Optional<PresalesModel> findById(String id);

    Optional<PresalesModel> findByName(String name);

    Optional<PresalesModel> findByUser_Id(String userId);

    List<PresalesModel> findAll();

    PresalesModel save(PresalesModel PresalesModel);

    boolean existsByDocumentNumber(Long documentNumber);
}
