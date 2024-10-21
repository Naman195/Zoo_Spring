package com.naman.zoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naman.zoo.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
		

}
