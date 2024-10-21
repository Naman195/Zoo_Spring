package com.naman.zoo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naman.zoo.entities.Address;
import com.naman.zoo.services.AddressService;

@RestController
@RequestMapping("/api/zoo")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/save-add")
	public Address saveAddress(@RequestBody Address address) {
		return addressService.createAddress(address);
	}
}
