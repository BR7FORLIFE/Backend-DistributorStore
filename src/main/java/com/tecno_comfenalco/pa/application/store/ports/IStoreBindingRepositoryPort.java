package com.tecno_comfenalco.pa.application.store.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.store.models.StoreBindingRequestModel;
import com.tecno_comfenalco.pa.shared.enums.BindingStatusEnum;
import com.tecno_comfenalco.pa.shared.utils.http.PagedResult;

public interface IStoreBindingRepositoryPort {
    boolean existsStoreBindingByNitAndDistributorId(String nit, UUID distributorId);

    StoreBindingRequestModel save(StoreBindingRequestModel model);

    PagedResult<StoreBindingRequestModel> findAllPaged(UUID distributorId, String name, Integer page, Integer size,
            String sortBy, String direction);

    Optional<StoreBindingRequestModel> findById(UUID bindingId);

    Optional<StoreBindingRequestModel> findByNitAndToken(String nit, String token);

    List<StoreBindingRequestModel> findByNitAndBindingStatusAndIsConsumedTrue(String nit,
            BindingStatusEnum statusEnum);
}
