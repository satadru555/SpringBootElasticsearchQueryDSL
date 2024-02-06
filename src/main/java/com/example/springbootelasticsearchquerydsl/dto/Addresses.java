package com.example.springbootelasticsearchquerydsl.dto;

import java.util.List;
import java.util.Objects;

public class Addresses {
    private String customerAddressId;
    private String sourceId;
    private String sourceType;
    private String addressType;
    private List<AddressStates> addressStates;


    public String getCustomerAddressId() {
        return customerAddressId;
    }

    public void setCustomerAddressId(String customerAddressId) {
        this.customerAddressId = customerAddressId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public List<AddressStates> getAddressStates() {
        return addressStates;
    }

    public void setAddressStates(List<AddressStates> addressStates) {
        this.addressStates = addressStates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Addresses addresses = (Addresses) o;
        return Objects.equals(customerAddressId, addresses.customerAddressId) && Objects.equals(sourceId, addresses.sourceId) && Objects.equals(sourceType, addresses.sourceType) && Objects.equals(addressType, addresses.addressType) && Objects.equals(addressStates, addresses.addressStates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerAddressId, sourceId, sourceType, addressType, addressStates);
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "customerAddressId='" + customerAddressId + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", addressType='" + addressType + '\'' +
                ", addressStates=" + addressStates +
                '}';
    }
}
