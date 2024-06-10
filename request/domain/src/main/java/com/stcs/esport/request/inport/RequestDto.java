package com.stcs.esport.request.inport;

import com.stcs.esport.request.model.Country;
import com.stcs.esport.request.model.status.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    private UUID id;
    private String ownerName;
    private String countryCode;
    private String mobileNumber;
    private String nationalId;
    private String email;
    private String clubName;
    private String clubNameAr;
    private String clubIBAN;
    private Country nationality;
    private RequestStatusDto status;


}
