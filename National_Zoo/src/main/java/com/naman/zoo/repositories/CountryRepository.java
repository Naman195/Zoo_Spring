package com.naman.zoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naman.zoo.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
	
 
}
