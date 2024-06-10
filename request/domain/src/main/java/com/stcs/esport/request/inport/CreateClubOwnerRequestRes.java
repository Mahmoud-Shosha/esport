package com.stcs.esport.request.inport;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateClubOwnerRequestRes {

    private ClubOwnerRequestDto clubOwnerRequest;
    private UserDto user;

}
