package com.stcs.esport.request.inport;

import com.stcs.esport.request.model.Country;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private UUID id;
    private String name;
    private String countryCode;
    private String mobileNumber;
    private String email;
    private Country nationality;

}
