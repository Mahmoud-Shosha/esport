package com.stcs.esport.request.inport;

import com.stcs.esport.common.validation.BeanValidator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateClubOwnerRequestCommand(@NotNull @Size(min = 3, max = 255) String ownerName,
                                            @NotNull @Size(min = 3, max = 255) String clubName,
                                            @NotNull @Size(min = 3, max = 255) String clubNameAr,
                                            @NotNull @Size(min = 3, max = 3) String countryCode,
                                            @NotNull @Size(min = 3, max = 255) String mobileNumber,
                                            @NotNull @Size(min = 15, max = 15) String nationalId,
                                            @NotNull @Email String email,
                                            @NotNull String IBAN,
                                            @NotNull UUID nationalityCountryId) {

    public CreateClubOwnerRequestCommand(String ownerName, String clubName, String clubNameAr, String countryCode, String mobileNumber, String nationalId, String email, String IBAN, UUID nationalityCountryId) {
        this.ownerName = ownerName;
        this.clubName = clubName;
        this.clubNameAr = clubNameAr;
        this.countryCode = countryCode;
        this.mobileNumber = mobileNumber;
        this.nationalId = nationalId;
        this.email = email;
        this.IBAN = IBAN;
        this.nationalityCountryId = nationalityCountryId;
        BeanValidator.validate(this);
    }
}
