package com.tecno_comfenalco.pa.features.store.models;

import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;

public class StoreDistributorModel {
    private Long id;

    private StoreModel store;

    private DistributorModel distributor;

    /**
     * Código de cliente interno que la distribuidora usa para identificar a esta
     * tienda
     * Útil para sincronización con sistemas ERP externos
     */
    private String internalClientCode;

    public StoreDistributorModel() {
    }

    public StoreDistributorModel(Long id, StoreModel store, DistributorModel distributor, String internalClientCode) {
        this.id = id;
        this.store = store;
        this.distributor = distributor;
        this.internalClientCode = internalClientCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StoreModel getStore() {
        return store;
    }

    public void setStore(StoreModel store) {
        this.store = store;
    }

    public DistributorModel getDistributor() {
        return distributor;
    }

    public void setDistributor(DistributorModel distributor) {
        this.distributor = distributor;
    }

    public String getInternalClientCode() {
        return internalClientCode;
    }

    public void setInternalClientCode(String internalClientCode) {
        this.internalClientCode = internalClientCode;
    }

}
