package com.stcs.esport.request.inport;

import java.util.UUID;

public class CreateClubOwnerRequestCommandBuilder {
    private String ownerName;
    private String clubName;
    private String clubNameAr;
    private String countryCode;
    private String mobileNumber;
    private String nationalId;
    private String email;
    private String iban;
    private UUID nationalityCountryId;

    public CreateClubOwnerRequestCommandBuilder setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public CreateClubOwnerRequestCommandBuilder setClubName(String clubName) {
        this.clubName = clubName;
        return this;
    }

    public CreateClubOwnerRequestCommandBuilder setClubNameAr(String clubNameAr) {
        this.clubNameAr = clubNameAr;
        return this;
    }

    public CreateClubOwnerRequestCommandBuilder setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public CreateClubOwnerRequestCommandBuilder setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public CreateClubOwnerRequestCommandBuilder setNationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public CreateClubOwnerRequestCommandBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateClubOwnerRequestCommandBuilder setIBAN(String iban) {
        this.iban = iban;
        return this;
    }

    public CreateClubOwnerRequestCommandBuilder setNationalityCountryId(UUID nationalityCountryId) {
        this.nationalityCountryId = nationalityCountryId;
        return this;
    }

    public CreateClubOwnerRequestCommand createCreateClubOwnerRequestCommand() {
        return new CreateClubOwnerRequestCommand(ownerName, clubName, clubNameAr, countryCode, mobileNumber, nationalId, email, iban, nationalityCountryId);
    }
}