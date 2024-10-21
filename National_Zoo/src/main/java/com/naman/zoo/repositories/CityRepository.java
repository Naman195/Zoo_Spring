package com.naman.zoo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naman.zoo.entities.City;

public interface CityRepository extends JpaRepository<City, Long>{
	List<City> findByStateStateId(Long stateId);

}
