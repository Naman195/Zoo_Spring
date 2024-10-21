package com.naman.zoo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naman.zoo.entities.State;
import com.naman.zoo.services.StateService;

@RestController
@RequestMapping("/api/zoo")
public class StateController  {

	@Autowired
	private StateService stateService;
	
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/state/{id}")
	public List<State> getAllStates(@PathVariable Long id){
		List<State> states = stateService.getStatesByCountryId(id);
		return states;
	}
	
	
}

