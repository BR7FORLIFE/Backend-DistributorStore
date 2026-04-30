package com.tecno_comfenalco.pa.application.store.ports;

import java.util.Optional;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.store.models.StoreModel;
import com.tecno_comfenalco.pa.shared.utils.http.PagedResult;

public interface IStoreRepositoryPort {
    boolean existsStoreByNit(String nit);

    StoreModel save(StoreModel storeModel);

    PagedResult<StoreModel> findAllpaged(Integer page, Integer size, String sortBy, String direction);

    Optional<StoreModel> findById(UUID id);
}
