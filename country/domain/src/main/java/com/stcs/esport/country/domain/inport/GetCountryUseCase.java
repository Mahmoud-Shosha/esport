package com.stcs.esport.country.domain.inport;

import java.util.UUID;

public interface GetCountryUseCase {

    CountryDto getCountryById(UUID id);

}
