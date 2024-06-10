package com.stcs.esport.request.outport;

import com.stcs.esport.request.model.Country;

import java.util.Optional;
import java.util.UUID;

public interface GetCountryPort {

    Country getCountryById(UUID id);

}
