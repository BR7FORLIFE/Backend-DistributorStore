package com.tecno_comfenalco.pa.features.distributor.models;

import java.util.List;

import com.tecno_comfenalco.pa.features.store.models.StoreDistributorModel;
import com.tecno_comfenalco.pa.security.model.UserModel;
import com.tecno_comfenalco.pa.shared.dto.DirectionDto;

public class DistributorModel {

    private Long id;

    private Long NIT;

    private String name;
    private String phoneNumber;
    private String email;

    private DirectionDto direction;

    private UserModel user;

    private List<StoreDistributorModel> storesDistributors;

    public DistributorModel() {
    }

    public DistributorModel(Long id, Long nIT, String name, String phoneNumber, String email, DirectionDto direction,
            UserModel user, List<StoreDistributorModel> storesDistributors) {
        this.id = id;
        NIT = nIT;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.direction = direction;
        this.user = user;
        this.storesDistributors = storesDistributors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<StoreDistributorModel> getStoresDistributors() {
        return storesDistributors;
    }

    public void setStoresDistributors(List<StoreDistributorModel> storesDistributors) {
        this.storesDistributors = storesDistributors;
    }

}
