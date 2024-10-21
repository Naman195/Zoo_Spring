package com.naman.zoo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naman.zoo.entities.City;
import com.naman.zoo.services.CityService;

@RestController
@RequestMapping("/api/zoo")
public class CityController {

	@Autowired
	private CityService cityService;
	
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/cities/{cityId}")
	public List<City> getAllCities(@PathVariable  Long cityId)
	{
		return cityService.getAllCitiesById(cityId);
	}
}