package com.paloma.citiesapi.countries;

import com.paloma.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository <Country, Long>{
}
