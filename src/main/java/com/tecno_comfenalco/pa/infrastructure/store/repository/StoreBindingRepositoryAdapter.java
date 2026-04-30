package com.tecno_comfenalco.pa.infrastructure.store.repository;

import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.application.store.ports.IStoreBindingRepositoryPort;
import com.tecno_comfenalco.pa.infrastructure.store.repository.mongo.StoreBindingRepository;

@Repository
public class StoreBindingRepositoryAdapter implements IStoreBindingRepositoryPort {

    private final StoreBindingRepository storeBindingRepository;

    public StoreBindingRepositoryAdapter(StoreBindingRepository storeBindingRepository) {
        this.storeBindingRepository = storeBindingRepository;
    }
}
