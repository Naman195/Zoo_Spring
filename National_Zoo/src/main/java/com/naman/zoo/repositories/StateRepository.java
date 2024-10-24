package com.naman.zoo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naman.zoo.entities.State;

public interface StateRepository extends JpaRepository<State, Long> 
{
	List<State> findByCountryCountryId(Long countryId);
}
