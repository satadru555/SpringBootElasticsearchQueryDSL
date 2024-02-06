package com.example.springbootelasticsearchquerydsl.dto;

import java.util.Objects;

public class ContactPointStates {

    private String emailAddress;
    private String validfrom;
    private String userId;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(String validfrom) {
        this.validfrom = validfrom;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactPointStates that = (ContactPointStates) o;
        return Objects.equals(emailAddress, that.emailAddress) && Objects.equals(validfrom, that.validfrom) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress, validfrom, userId);
    }

    @Override
    public String toString() {
        return "ConactPointStates{" +
                "emailAddress='" + emailAddress + '\'' +
                ", validfrom='" + validfrom + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
