package com.tecno_comfenalco.pa.features.store.models;

import java.util.UUID;

import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;

public class StoreDistributorModel {
    private String id;

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

    public StoreDistributorModel(String id, StoreModel store, DistributorModel distributor, String internalClientCode) {
        this.id = id;
        this.store = store;
        this.distributor = distributor;
        this.internalClientCode = internalClientCode;
    }

    public static StoreDistributorModel createDraft(
            StoreModel store,
            DistributorModel distributor,
            String internalClientCode) {

        return new StoreDistributorModel(
                UUID.randomUUID().toString(),
                store,
                distributor,
                internalClientCode);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
