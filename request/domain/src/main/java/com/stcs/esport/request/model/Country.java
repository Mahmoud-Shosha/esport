package com.stcs.esport.request.model;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class Country {

    private UUID id;
    private String name;
    private String nameAr;
    private String code;

}
