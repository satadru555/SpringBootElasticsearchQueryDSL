/*package com.example.springbootelasticsearchquerydsl.entity;

import com.example.springbootelasticsearchquerydsl.dto.Addresses;
import com.example.springbootelasticsearchquerydsl.dto.EmailContactDetails;
import com.example.springbootelasticsearchquerydsl.dto.PhoneContactPointDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "partner")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Partner {

    private String partyId;
    private String partyNumber;
    private String partyType;
    private String createdDate;
    private String createdBy;
    private String dataOrigin;
    private String validFrom;
    private String validUntil;
    private String primaryLanguageCode;
    private String professionalTitle;
    private String suffix;
    private String name;
    private String firstName;
    private String middleName;
    private String nationality;

    private String birthDate;

    private String dateOfDeath;
    private String deathIndicator;
    private String maritialStatus;
    private String gender;
    private String placeOfOrigin;
    private String residencePermit;
    private String employeeId;

    private List<Addresses> addresses;
    private List<PhoneContactPointDetails> phoneContactPointDetails;
    private List<EmailContactDetails> emailContactDetails;

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyNumber() {
        return partyNumber;
    }

    public void setPartyNumber(String partyNumber) {
        this.partyNumber = partyNumber;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDataOrigin() {
        return dataOrigin;
    }

    public void setDataOrigin(String dataOrigin) {
        this.dataOrigin = dataOrigin;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public String getPrimaryLanguageCode() {
        return primaryLanguageCode;
    }

    public void setPrimaryLanguageCode(String primaryLanguageCode) {
        this.primaryLanguageCode = primaryLanguageCode;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getDeathIndicator() {
        return deathIndicator;
    }

    public void setDeathIndicator(String deathIndicator) {
        this.deathIndicator = deathIndicator;
    }

    public String getMaritialStatus() {
        return maritialStatus;
    }

    public void setMaritialStatus(String maritialStatus) {
        this.maritialStatus = maritialStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getResidencePermit() {
        return residencePermit;
    }

    public void setResidencePermit(String residencePermit) {
        this.residencePermit = residencePermit;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<Addresses> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Addresses> addresses) {
        this.addresses = addresses;
    }

    public List<PhoneContactPointDetails> getPhoneContactPointDetails() {
        return phoneContactPointDetails;
    }

    public void setPhoneContactPointDetails(List<PhoneContactPointDetails> phoneContactPointDetails) {
        this.phoneContactPointDetails = phoneContactPointDetails;
    }

    public List<EmailContactDetails> getEmailContactDetails() {
        return emailContactDetails;
    }

    public void setEmailContactDetails(List<EmailContactDetails> emailContactDetails) {
        this.emailContactDetails = emailContactDetails;
    }
}
*/