package com.stcs.esport.country.domain.outport;

import com.stcs.esport.country.domain.model.Country;

import java.util.Optional;
import java.util.UUID;

public interface GetCountryPort {

    Optional<Country> getCountryById(UUID id);

}
