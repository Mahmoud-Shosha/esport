package com.stcs.esport.country.domain.service;

import com.stcs.esport.common.exception.NotFoundException;
import com.stcs.esport.country.domain.inport.CountryDto;
import com.stcs.esport.country.domain.inport.GetCountryUseCase;
import com.stcs.esport.country.domain.model.Country;
import com.stcs.esport.country.domain.outport.GetCountryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.stcs.esport.country.domain.enums.CountryErrorCode.COUNTRY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class GetCountryService implements GetCountryUseCase {

    private final GetCountryPort getCountryPort;

    @Override
    public CountryDto getCountryById(UUID id) {
        Country country = getCountryPort.getCountryById(id)
                .orElseThrow(() -> new NotFoundException(COUNTRY_NOT_FOUND));
        return buildCountryDto(country);
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
