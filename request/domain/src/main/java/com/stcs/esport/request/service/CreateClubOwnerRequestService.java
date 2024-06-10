package com.stcs.esport.request.service;

import com.stcs.esport.request.inport.*;
import com.stcs.esport.request.model.ClubOwnerRequest;
import com.stcs.esport.request.model.Country;
import com.stcs.esport.request.model.User;
import com.stcs.esport.request.model.status.RequestStatusCode;
import com.stcs.esport.request.outport.CreateRequestPort;
import com.stcs.esport.request.outport.CreateUserPort;
import com.stcs.esport.request.outport.GetCountryPort;
import com.stcs.esport.request.outport.GetRequestStatusPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateClubOwnerRequestService implements CreateClubOwnerRequestUseCase {

    private final GetCountryPort getCountryPort;
    private final CreateRequestPort createRequestPort;
    private final CreateUserPort createUserPort;
    private final GetRequestStatusPort getRequestStatusPort;
    private final ModelMapper mapper;

    @Override
    public CreateClubOwnerRequestRes createClubOwnerRequest(CreateClubOwnerRequestCommand command) {
        ClubOwnerRequest clubOwnerRequest = getClubOwnerRequest(command);
        createRequestPort.createRequest(clubOwnerRequest);
        User user = getUser(command);
        createUserPort.CreateUser(user);
        return buildCreateClubOwnerRequestRes(clubOwnerRequest, user);
    }

    private ClubOwnerRequest getClubOwnerRequest(CreateClubOwnerRequestCommand command) {
        Country country = getCountryPort.getCountryById(command.nationalityCountryId());
        return ClubOwnerRequest.builder()
                .id(UUID.randomUUID())
                .status(getRequestStatusPort.getRequestStatusByCode(RequestStatusCode.NEW))
                .ownerName(command.ownerName())
                .clubName(command.clubName())
                .clubNameAr(command.clubNameAr())
                .clubIBAN(command.IBAN())
                .email(command.email())
                .countryCode(command.countryCode())
                .mobileNumber(command.mobileNumber())
                .nationalId(command.nationalId())
                .nationality(country)
                .build();
    }

    private User getUser(CreateClubOwnerRequestCommand command) {
        Country country = getCountryPort.getCountryById(command.nationalityCountryId());
        return User.builder()
                .id(UUID.randomUUID())
                .name(command.ownerName())
                .countryCode(command.countryCode())
                .mobileNumber(command.mobileNumber())
                .email(command.email())
                .nationality(country)
                .build();
    }

    private CreateClubOwnerRequestRes buildCreateClubOwnerRequestRes(ClubOwnerRequest clubOwnerRequest, User user) {
        ClubOwnerRequestDto clubOwnerRequestDto = mapper.map(clubOwnerRequest, ClubOwnerRequestDto.class);
        clubOwnerRequestDto.setStatus(mapper.map(clubOwnerRequest.getStatus(), RequestStatusDto.class));
        return CreateClubOwnerRequestRes.builder()
                .clubOwnerRequest(clubOwnerRequestDto)
                .user(mapper.map(user, UserDto.class))
                .build();
    }
}
