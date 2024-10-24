package com.naman.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naman.zoo.entities.City;
import com.naman.zoo.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public List<City> getAllCitiesById(Long id){
		return cityRepository.findByStateStateId(id);
	}
	
}
