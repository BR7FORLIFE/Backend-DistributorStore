
package com.tecno_comfenalco.pa.domain.store.models;

import java.time.Instant;
import java.util.UUID;

import com.tecno_comfenalco.pa.shared.enums.BindingStatusEnum;

public class StoreBindingRequestModel {
    private UUID id;
    private UUID presalesId;
    private UUID distributorId;
    private String nit;
    private String tempName;
    private BindingStatusEnum bindingStatus;
    private String activationCode;
    private Instant createAt;

    public static StoreBindingRequestModel createDraft(UUID presalesId, UUID distributorId, String nit,
            String tempName, BindingStatusEnum bindingStatus, String activationCode, Instant createAt) {
        return new StoreBindingRequestModel(UUID.randomUUID(), presalesId, distributorId, nit, tempName,
                BindingStatusEnum.PENDING,
                activationCode, Instant.now());
    }

    public static StoreBindingRequestModel createNew(UUID id, UUID presalesId, UUID distributorId, String nit,
            String tempName, BindingStatusEnum bindingStatus, String activationCode, Instant createAt) {
        return new StoreBindingRequestModel(id, presalesId, distributorId, nit, tempName, bindingStatus, activationCode,
                createAt);
    }

    public StoreBindingRequestModel(UUID id, UUID presalesId, UUID distributorId, String nit, String tempName,
            BindingStatusEnum bindingStatus, String activationCode, Instant createAt) {
        this.id = id;
        this.presalesId = presalesId;
        this.distributorId = distributorId;
        this.nit = nit;
        this.tempName = tempName;
        this.bindingStatus = bindingStatus;
        this.activationCode = activationCode;
        this.createAt = createAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getPresalesId() {
        return presalesId;
    }

    public UUID getDistributorId() {
        return distributorId;
    }

    public String getNit() {
        return nit;
    }

    public String getTempName() {
        return tempName;
    }

    public BindingStatusEnum getBindingStatus() {
        return bindingStatus;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public Instant getCreateAt() {
        return createAt;
    }

}
