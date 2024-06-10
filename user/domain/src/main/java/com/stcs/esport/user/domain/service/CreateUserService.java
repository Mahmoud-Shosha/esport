package com.stcs.esport.user.domain.service;

import com.stcs.esport.user.domain.inport.CountryDto;
import com.stcs.esport.user.domain.inport.CreateUserCommand;
import com.stcs.esport.user.domain.inport.CreateUserUseCase;
import com.stcs.esport.user.domain.inport.UserDto;
import com.stcs.esport.user.domain.model.Country;
import com.stcs.esport.user.domain.model.User;
import com.stcs.esport.user.domain.outport.CreateUserPort;
import com.stcs.esport.user.domain.outport.GetCountryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final GetCountryPort getCountryPort;
    private final CreateUserPort createUserPort;


    @Override
    public UserDto createUser(CreateUserCommand command) {
        User user = getUser(command);
        User createdUser = createUserPort.createUser(user);
        return buildUserDto(createdUser);
    }


    private User getUser(CreateUserCommand command) {
        Country country = getCountryPort.getCountryById(command.nationalityCountryId());
        return User.builder()
                .id(UUID.randomUUID())
                .name(command.name())
                .email(command.email())
                .countryCode(command.countryCode())
                .mobileNumber(command.mobileNumber())
                .nationality(country)
                .build();
    }

    private UserDto buildUserDto(User createdUser) {
        return UserDto.builder()
                .id(createdUser.getId())
                .name(createdUser.getName())
                .email(createdUser.getEmail())
                .countryCode(createdUser.getCountryCode())
                .mobileNumber(createdUser.getMobileNumber())
                .nationality(buildCountryDto(createdUser.getNationality()))
                .build();
    }

    private CountryDto buildCountryDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .nameAr(country.getNameAr())
                .code(country.getCode())
                .build();
    }

}
