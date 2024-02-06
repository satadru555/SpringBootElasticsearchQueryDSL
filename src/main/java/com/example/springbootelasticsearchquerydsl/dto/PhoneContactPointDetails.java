package com.example.springbootelasticsearchquerydsl.dto;

import java.util.List;
import java.util.Objects;

public class PhoneContactPointDetails {


    private String contactPointType;
    private String contactPointId;
    private String partnerId;
    private String exPartyId;
    private String isTermination;
    private List<com.example.springbootelasticsearchquerydsl.dto.ContactPointStates> ContactPointStates;

    public String getContactPointType() {
        return contactPointType;
    }

    public void setContactPointType(String contactPointType) {
        this.contactPointType = contactPointType;
    }

    public String getContactPointId() {
        return contactPointId;
    }

    public void setContactPointId(String contactPointId) {
        this.contactPointId = contactPointId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getExPartyId() {
        return exPartyId;
    }

    public void setExPartyId(String exPartyId) {
        this.exPartyId = exPartyId;
    }

    public String getIsTermination() {
        return isTermination;
    }

    public void setIsTermination(String isTermination) {
        this.isTermination = isTermination;
    }

    public List<com.example.springbootelasticsearchquerydsl.dto.ContactPointStates> getConactPointStates() {
        return ContactPointStates;
    }

    public void setConactPointStates(List<com.example.springbootelasticsearchquerydsl.dto.ContactPointStates> contactPointStates) {
        ContactPointStates = contactPointStates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneContactPointDetails that = (PhoneContactPointDetails) o;
        return Objects.equals(contactPointType, that.contactPointType) && Objects.equals(contactPointId, that.contactPointId) && Objects.equals(partnerId, that.partnerId) && Objects.equals(exPartyId, that.exPartyId) && Objects.equals(isTermination, that.isTermination) && Objects.equals(ContactPointStates, that.ContactPointStates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactPointType, contactPointId, partnerId, exPartyId, isTermination, ContactPointStates);
    }


    @Override
    public String toString() {
        return "PhoneContactPointDetails{" +
                "contactPointType='" + contactPointType + '\'' +
                ", contactPointId='" + contactPointId + '\'' +
                ", partnerId='" + partnerId + '\'' +
                ", exPartyId='" + exPartyId + '\'' +
                ", isTermination='" + isTermination + '\'' +
                ", ConactPointStates=" + ContactPointStates +
                '}';
    }
}
