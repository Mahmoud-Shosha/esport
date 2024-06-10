package com.stcs.esport.user.domain.outport;

import com.stcs.esport.user.domain.model.Country;

import java.util.UUID;

public interface GetCountryPort {

    Country getCountryById(UUID id);

}
