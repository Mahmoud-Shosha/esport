package com.stcs.esport.country.outadapter.sql.repo;


import com.stcs.esport.country.outadapter.sql.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountryRepo extends JpaRepository<CountryEntity, UUID> {
}
