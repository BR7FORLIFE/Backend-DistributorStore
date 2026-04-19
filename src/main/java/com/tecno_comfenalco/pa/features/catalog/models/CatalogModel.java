package com.tecno_comfenalco.pa.features.catalog.models;

import java.util.UUID;

import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;

public class CatalogModel {

    private String id;
    private DistributorModel distributor;

    public CatalogModel() {
    }

    public static CatalogModel createDraft(DistributorModel distributor) {
        return new CatalogModel(UUID.randomUUID().toString(), distributor);
    }

    public CatalogModel(String id, DistributorModel distributor) {
        this.id = id;
        this.distributor = distributor;
    }

    public String getId() {
        return id;
    }

    public DistributorModel getDistributor() {
        return distributor;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDistributor(DistributorModel distributor) {
        this.distributor = distributor;
    }

}
