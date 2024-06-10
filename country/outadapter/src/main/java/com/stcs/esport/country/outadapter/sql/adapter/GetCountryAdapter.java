package com.stcs.esport.country.outadapter.sql.adapter;

import com.stcs.esport.country.domain.model.Country;
import com.stcs.esport.country.domain.outport.GetCountryPort;
import com.stcs.esport.country.outadapter.sql.repo.CountryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetCountryAdapter implements GetCountryPort {

    private final CountryRepo countryRepo;

    @Override
    public Optional<Country> getCountryById(UUID id) {
        return countryRepo.findById(id)
                .map(entity -> Country.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .nameAr(entity.getNameAr())
                        .code(entity.getCode())
                        .build()
                );
    }
}
