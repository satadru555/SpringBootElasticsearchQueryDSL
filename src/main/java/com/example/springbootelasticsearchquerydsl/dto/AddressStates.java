package com.example.springbootelasticsearchquerydsl.dto;

import java.util.Objects;

public class AddressStates {

    private String addressOrder;
    private String cpPermissionType;
    private String streetName;
    private String houseNumber;
    private String postOfficeBox;

    private String postCode;
    private String minucipality;
    private String countrycode;

    public String getAddressOrder() {
        return addressOrder;
    }

    public void setAddressOrder(String addressOrder) {
        this.addressOrder = addressOrder;
    }

    public String getCpPermissionType() {
        return cpPermissionType;
    }

    public void setCpPermissionType(String cpPermissionType) {
        this.cpPermissionType = cpPermissionType;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostOfficeBox() {
        return postOfficeBox;
    }

    public void setPostOfficeBox(String postOfficeBox) {
        this.postOfficeBox = postOfficeBox;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getMinucipality() {
        return minucipality;
    }

    public void setMinucipality(String minucipality) {
        this.minucipality = minucipality;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    @Override
    public String toString() {
        return "AddressStates{" +
                "addressOrder='" + addressOrder + '\'' +
                ", cpPermissionType='" + cpPermissionType + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", postOfficeBox='" + postOfficeBox + '\'' +
                ", postCode='" + postCode + '\'' +
                ", minucipality='" + minucipality + '\'' +
                ", countrycode='" + countrycode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressStates that = (AddressStates) o;
        return Objects.equals(addressOrder, that.addressOrder) && Objects.equals(cpPermissionType, that.cpPermissionType) && Objects.equals(streetName, that.streetName) && Objects.equals(houseNumber, that.houseNumber) && Objects.equals(postOfficeBox, that.postOfficeBox) && Objects.equals(postCode, that.postCode) && Objects.equals(minucipality, that.minucipality) && Objects.equals(countrycode, that.countrycode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressOrder, cpPermissionType, streetName, houseNumber, postOfficeBox, postCode, minucipality, countrycode);
    }
}
