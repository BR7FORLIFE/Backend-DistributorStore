package com.tecno_comfenalco.pa.features.store.entity.mongo;

import java.util.List;

import com.tecno_comfenalco.pa.features.routes.presales.entity.mongo.PresalesRoutesDocument;
import com.tecno_comfenalco.pa.security.entity.mongo.UserDocument;
import com.tecno_comfenalco.pa.shared.dto.DirectionDto;
import com.tecno_comfenalco.pa.shared.enums.StoreClaimStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "stores")
@Data
@EqualsAndHashCode(exclude = { "user", "presalesRoute", "storesDistributors" })
@ToString(exclude = { "user", "presalesRoute", "storesDistributors" })
public class StoreDocument {

    @Id
    private String id;

    private Long NIT;

    private String name;
    private String phoneNumber;
    private String email;

    private DirectionDto direction;

    @DBRef
    private UserDocument user;

    private StoreClaimStatus claimStatus = StoreClaimStatus.PENDING_CLAIM;

    @DBRef
    private PresalesRoutesDocument presalesRoute;

    @DBRef
    private List<StoresDistributorsDocument> storesDistributors;
}
