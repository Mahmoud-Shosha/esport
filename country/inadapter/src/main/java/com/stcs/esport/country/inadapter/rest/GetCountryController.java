package com.stcs.esport.country.inadapter.rest;


import com.stcs.esport.country.domain.inport.CountryDto;
import com.stcs.esport.country.domain.inport.GetCountryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/countries")
@RequiredArgsConstructor
public class GetCountryController {

    private final GetCountryUseCase getCountryUseCase;

    @GetMapping("/{id}")
    public CountryDto getCountryById(@PathVariable UUID id) {
        return getCountryUseCase.getCountryById(id);
    }

}
