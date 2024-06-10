package com.stcs.esport.user.outadapter.adapter;


import com.stcs.esport.country.domain.inport.CountryDto;
import com.stcs.esport.country.domain.inport.GetCountryUseCase;
import com.stcs.esport.user.domain.model.Country;
import com.stcs.esport.user.domain.outport.GetCountryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetCountryDomainAdapter implements GetCountryPort {

    private final GetCountryUseCase getCountryUseCase;


    @Override
    public Country getCountryById(UUID id) {
        CountryDto countryDto = getCountryUseCase.getCountryById(id);
        return buildCountry(countryDto);
    }

    private Country buildCountry(CountryDto countryDto) {
        return Country.builder()
                .id(countryDto.getId())
                .name(countryDto.getName())
                .nameAr(countryDto.getNameAr())
                .code(countryDto.getCode())
                .build();
    }
}
