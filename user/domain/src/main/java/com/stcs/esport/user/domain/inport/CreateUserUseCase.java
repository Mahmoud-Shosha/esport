package com.stcs.esport.user.domain.inport;

public interface CreateUserUseCase {

    UserDto createUser(CreateUserCommand command);

}
