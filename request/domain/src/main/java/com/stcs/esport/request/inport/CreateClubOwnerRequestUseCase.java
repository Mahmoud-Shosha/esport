package com.stcs.esport.request.inport;

import org.springframework.transaction.annotation.Transactional;

public interface CreateClubOwnerRequestUseCase {

    @Transactional
    CreateClubOwnerRequestRes createClubOwnerRequest(CreateClubOwnerRequestCommand command);

}
