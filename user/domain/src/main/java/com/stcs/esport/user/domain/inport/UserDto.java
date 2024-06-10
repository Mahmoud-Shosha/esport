package com.stcs.esport.user.domain.inport;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class UserDto {

    private UUID id;
    private String name;
    private String countryCode;
    private String mobileNumber;
    private String email;
    private CountryDto nationality;

}

