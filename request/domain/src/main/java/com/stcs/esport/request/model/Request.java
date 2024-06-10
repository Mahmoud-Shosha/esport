package com.stcs.esport.request.model;

import com.stcs.esport.request.inport.CreateClubOwnerRequestCommand;
import com.stcs.esport.request.model.status.RequestStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {

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
    private RequestStatus status;


}
