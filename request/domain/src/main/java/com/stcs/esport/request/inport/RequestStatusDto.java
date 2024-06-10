package com.stcs.esport.request.inport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestStatusDto {


    private UUID id;
    private String name;
    private String nameAr;
    private RequestStatusCode code;

}
