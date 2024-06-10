package com.stcs.esport.request.outadapter.sql.adapter;

import com.stcs.esport.request.model.Country;
import com.stcs.esport.request.model.User;
import com.stcs.esport.request.outport.CreateUserPort;
import com.stcs.esport.request.outport.GetCountryPort;
import com.stcs.esport.user.domain.inport.CreateUserCommand;
import com.stcs.esport.user.domain.inport.CreateUserUseCase;
import com.stcs.esport.user.domain.inport.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAdapter implements CreateUserPort {

    private final CreateUserUseCase createUserUseCase;
    private final GetCountryPort getCountryPort;

    @Override
    public User CreateUser(User user) {
        CreateUserCommand createCommand = getCreateUserCommand(user);
        UserDto userDto = createUserUseCase.createUser(createCommand);
        return buildUser(userDto);
    }

    private CreateUserCommand getCreateUserCommand(User user) {
        return CreateUserCommand.builder()
                .name(user.getName())
                .nationalityCountryId(user.getNationality().getId())
                .email(user.getEmail())
                .countryCode(user.getCountryCode())
                .mobileNumber(user.getMobileNumber())
                .build();
    }

    private User buildUser(UserDto userDto) {
        Country country = getCountryPort.getCountryById(userDto.getNationality().getId());
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .nationality(country)
                .email(userDto.getEmail())
                .countryCode(userDto.getCountryCode())
                .mobileNumber(userDto.getMobileNumber())
                .build();
    }
}
