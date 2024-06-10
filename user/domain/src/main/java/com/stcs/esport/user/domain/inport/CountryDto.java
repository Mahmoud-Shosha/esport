package com.stcs.esport.user.domain.inport;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class CountryDto {

    private UUID id;
    private String name;
    private String nameAr;
    private String code;

}
