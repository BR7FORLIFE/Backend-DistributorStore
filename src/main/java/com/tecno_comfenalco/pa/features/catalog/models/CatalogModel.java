package com.tecno_comfenalco.pa.features.catalog.models;

import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;

public class CatalogModel {

    private Long id;
    private DistributorModel distributor;

    public CatalogModel() {
    }

    public CatalogModel(Long id, DistributorModel distributor) {
        this.id = id;
        this.distributor = distributor;
    }

    public Long getId() {
        return id;
    }

    public DistributorModel getDistributor() {
        return distributor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDistributor(DistributorModel distributor) {
        this.distributor = distributor;
    }
    
}
