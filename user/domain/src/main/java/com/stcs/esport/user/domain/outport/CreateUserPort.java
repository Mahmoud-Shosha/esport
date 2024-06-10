package com.stcs.esport.user.domain.outport;

import com.stcs.esport.user.domain.model.User;

public interface CreateUserPort {

    User createUser(User user);

}
