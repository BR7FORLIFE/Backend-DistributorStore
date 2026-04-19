package com.tecno_comfenalco.pa.features.store.models;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.features.routes.models.presales.PresalesRoutesModel;
import com.tecno_comfenalco.pa.security.model.UserModel;
import com.tecno_comfenalco.pa.shared.dto.DirectionDto;
import com.tecno_comfenalco.pa.shared.enums.StoreClaimStatus;

public class StoreModel {
    private String id;

    private Long NIT;

    private String name;
    private String phoneNumber;
    private String email;

    private DirectionDto direction;

    // Usuario propietario (opcional: puede ser null si la tienda fue registrada por
    // una distribuidora)
    private UserModel user;

    // Estado de la tienda: PENDING_CLAIM, CLAIMED, SELF_REGISTERED
    private StoreClaimStatus claimStatus = StoreClaimStatus.PENDING_CLAIM;

    private PresalesRoutesModel presalesRoute;

    private List<StoreDistributorModel> storesDistributors;

    public StoreModel() {
    }

    public StoreModel(String id, Long nIT, String name, String phoneNumber, String email, DirectionDto direction,
            UserModel user, StoreClaimStatus claimStatus, PresalesRoutesModel presalesRoute,
            List<StoreDistributorModel> storesDistributors) {
        this.id = id;
        NIT = nIT;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.direction = direction;
        this.user = user;
        this.claimStatus = claimStatus;
        this.presalesRoute = presalesRoute;
        this.storesDistributors = storesDistributors;
    }

    public static StoreModel createDraft(
            Long NIT,
            String name,
            String phoneNumber,
            String email,
            DirectionDto direction,
            UserModel user,
            StoreClaimStatus claimStatus,
            PresalesRoutesModel presalesRoute,
            List<StoreDistributorModel> storesDistributors) {

        return new StoreModel(
                UUID.randomUUID().toString(), 
                NIT,
                name,
                phoneNumber,
                email,
                direction,
                user,
                claimStatus != null ? claimStatus : StoreClaimStatus.PENDING_CLAIM,
                presalesRoute,
                storesDistributors);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getNIT() {
        return NIT;
    }

    public void setNIT(Long nIT) {
        NIT = nIT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DirectionDto getDirection() {
        return direction;
    }

    public void setDirection(DirectionDto direction) {
        this.direction = direction;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public StoreClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(StoreClaimStatus claimStatus) {
        this.claimStatus = claimStatus;
    }

    public PresalesRoutesModel getPresalesRoute() {
        return presalesRoute;
    }

    public void setPresalesRoute(PresalesRoutesModel presalesRoute) {
        this.presalesRoute = presalesRoute;
    }

    public List<StoreDistributorModel> getStoresDistributors() {
        return storesDistributors;
    }

    public void setStoresDistributors(List<StoreDistributorModel> storesDistributors) {
        this.storesDistributors = storesDistributors;
    }

}
