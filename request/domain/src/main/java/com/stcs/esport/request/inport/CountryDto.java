package com.stcs.esport.request.inport;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
public class CountryDto {

    private UUID id;
    private String name;
    private String nameAr;
    private String code;

}
