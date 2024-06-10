package com.stcs.esport.request.model;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class User {

    private UUID id;
    private String name;
    private String countryCode;
    private String mobileNumber;
    private String email;
    private Country nationality;

}
