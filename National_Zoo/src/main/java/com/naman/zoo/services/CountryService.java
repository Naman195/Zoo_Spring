package com.naman.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naman.zoo.entities.Country;
import com.naman.zoo.repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public List<Country> getAllCountry(){
		List<Country> countries = countryRepository.findAll();
		return countries;
	}

}
