package com.naman.zoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naman.zoo.entities.Address;
import com.naman.zoo.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public Address createAddress(Address address) {
		return addressRepository.save(address);
		
	}
}
