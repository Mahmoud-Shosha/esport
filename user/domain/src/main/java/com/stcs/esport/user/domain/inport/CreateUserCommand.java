package com.stcs.esport.user.domain.inport;

import com.stcs.esport.common.validation.BeanValidator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateUserCommand(@NotNull @Size(min = 3, max = 255) String name,
                                @NotNull @Size(min = 3, max = 3) String countryCode,
                                @NotNull @Size(min = 3, max = 255) String mobileNumber,
                                @NotNull @Email String email,
                                @NotNull UUID nationalityCountryId) {

    public CreateUserCommand(String name, String countryCode, String mobileNumber, String email, UUID nationalityCountryId) {
        this.name = name;
        this.countryCode = countryCode;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.nationalityCountryId = nationalityCountryId;
        BeanValidator.validate(this);
    }
}
