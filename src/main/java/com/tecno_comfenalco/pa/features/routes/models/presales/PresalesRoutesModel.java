package com.tecno_comfenalco.pa.features.routes.models.presales;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.features.presales.models.PresalesModel;
import com.tecno_comfenalco.pa.features.store.models.StoreModel;

public class PresalesRoutesModel {

    private String id;

    private List<StoreModel> stores;

    private PresalesModel presalesRoute;

    public PresalesRoutesModel(String id, List<StoreModel> stores, PresalesModel presalesRoute) {
        this.id = id;
        this.stores = stores;
        this.presalesRoute = presalesRoute;
    }

    public static PresalesRoutesModel createDraft(
            List<StoreModel> stores,
            PresalesModel presalesRoute) {

        return new PresalesRoutesModel(
                UUID.randomUUID().toString(),
                stores,
                presalesRoute);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
