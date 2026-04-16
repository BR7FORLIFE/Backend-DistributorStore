package com.tecno_comfenalco.pa.features.routes.models.presales;

import java.util.List;

import com.tecno_comfenalco.pa.features.presales.models.PresalesModel;
import com.tecno_comfenalco.pa.features.store.models.StoreModel;

public class PresalesRoutesModel {

    private Long id;

    private List<StoreModel> stores;

    private PresalesModel presalesRoute;

    public PresalesRoutesModel(Long id, List<StoreModel> stores, PresalesModel presalesRoute) {
        this.id = id;
        this.stores = stores;
        this.presalesRoute = presalesRoute;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<StoreModel> getStores() {
        return stores;
    }

    public void setStores(List<StoreModel> stores) {
        this.stores = stores;
    }

    public PresalesModel getPresalesRoute() {
        return presalesRoute;
    }

    public void setPresalesRoute(PresalesModel presalesRoute) {
        this.presalesRoute = presalesRoute;
    }

}
