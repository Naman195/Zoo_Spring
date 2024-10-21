package com.naman.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naman.zoo.entities.State;
import com.naman.zoo.repositories.CountryRepository;
import com.naman.zoo.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private  StateRepository stateRepository;
	
	@Autowired
	private  CountryRepository countryRepository;
	
	
	
	public List<State> getStatesByCountryId(Long id)
	{
		return stateRepository.findByCountryCountryId(id);
	}
}
