package com.naman.zoo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naman.zoo.entities.Country;
import com.naman.zoo.services.CountryService;

@RestController
@RequestMapping("/api/zoo")
@CrossOrigin("http://localhost:3000")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		List<Country> countries =  countryService.getAllCountry();
		return countries;
	}
	

}
