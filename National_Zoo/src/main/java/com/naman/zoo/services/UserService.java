package com.naman.zoo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.naman.zoo.UserDTO.UpdateUserDTO;
import com.naman.zoo.UserDTO.UpdateUserDTO.AddressDTO;
import com.naman.zoo.UserDTO.UserResponse;
import com.naman.zoo.entities.Address;
import com.naman.zoo.entities.City;
import com.naman.zoo.entities.Country;
import com.naman.zoo.entities.State;
import com.naman.zoo.entities.User;
import com.naman.zoo.repositories.CityRepository;
import com.naman.zoo.repositories.CountryRepository;
import com.naman.zoo.repositories.StateRepository;
import com.naman.zoo.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CityRepository cityRepository;
	

	
	@Transactional
	public User createUser(User user) {
//		City city = cityRepository.findById(user.getAddress().getCity().getCityId()).get();
		
//		Address address = new Address();
//		address.setStreet(user.getAddress().getStreet());
//		address.setZipCode(user.getAddress().getZipCode());
//		address.setCreatedBy(user.getAddress().getCreatedBy());
//		address.setCity(city);
//		user.setAddress(address);
//		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//		String encryptedPassword =  bcrypt.encode(user.getPassword());
//		user.setPassword(encryptedPassword);
		return userRepository.save(user);
	}
	
	
	public List<User> getAllUser(){
		List<User> users =  userRepository.findAll();
		List<User> filteredusers = 	users.stream().filter(user -> !user.isArchieved()).collect(Collectors.toList());
		return filteredusers;
		
	}
	
	public User getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
		return user;
	}
	
	
	public User UpdateUserById(User user,  Long id) {
	
		User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found By Id"));
		System.out.println(existingUser);
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setUserName(user.getUsername());
		existingUser.setPassword(user.getPassword());
		existingUser.setAddress(user.getAddress());
		return userRepository.save(existingUser);
		
		
	}
	
	public void deleteUserById(Long id) {
		User deletedUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found By Id"));
		deletedUser.setArchieved(!deletedUser.isArchieved());
		userRepository.save(deletedUser);
		
	}
	
	public UserResponse LoginUser(String username, String password)
	{
//		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	
		User user = userRepository.findByuserName(username);
		if(user ==  null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong Username");
		}
		String pass = user.getPassword();
//		if(!bcrypt.matches(password, user.getPassword()))
		if(!pass.equals(password))
		{
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong Password");
		}
		
	
//		return new UserResponse(user.getUserId(), user.getUserName());
		return new UserResponse(user.getUserId(), user.getUsername());
	}
	
	
//	public User partialUpdateUser(Long userId, UpdateUserDTO dto) {
//	    Optional<User> optionalUser = userRepository.findById(userId);
//
//	    if (optionalUser.isPresent()) {
//	        User user = optionalUser.get();
//	        Address address = user.getAddress();
//
//	        // Update user fields
//	        if (dto.getFirstName() != null) {
//	            user.setFirstName(dto.getFirstName());
//	        }
//	        if (dto.getLastName() != null) {
//	            user.setLastName(dto.getLastName());
//	        }
//
//	        // Update address fields
//	        if (dto.getAddress() != null) {
//	            AddressDTO addressDTO = dto.getAddress();
//	            if (addressDTO.getStreet() != null) {
//	                address.setStreet(addressDTO.getStreet());
//	            }
//	            if (addressDTO.getZipCode() != null) {
//	                address.setZipCode(addressDTO.getZipCode());
//	            }
//
//	            // Update city if cityId is provided
//	            if (addressDTO.getCity() != null && addressDTO.getCity().getCityId() != null) {
//	                City city = cityRepository.findById(addressDTO.getCity().getCityId())
//	                    .orElseThrow(() -> new RuntimeException("City not found"));
//
//	                // Ensure that the city belongs to the selected state and country if needed
//	                address.setCity(city);
//	            }
//	            if (addressDTO.getCreatedBy() != null) {
//	                address.setCreatedBy(addressDTO.getCreatedBy());
//	            }
//	        }
//
//	        userRepository.save(user);
//	        return user;
//	    } else {
//	        throw new RuntimeException("User not found");
//	    }
//	}
	
//	public User partialUpdateUser(Long id, UpdateUserDTO dto)
//	{
//		Optional<User> optionalUser = userRepository.findById(id);
//		if(optionalUser.isPresent())
//		{
//			User user = optionalUser.get();
//			
//			Address address = user.getAddress();
//			
//			if(dto.getFirstName() != null)
//			{
//				user.setFirstName(dto.getFirstName());
//			}
//			
//			if(dto.getLastName() != null)
//			{
//				user.setLastName(dto.getLastName());
//			}
//			
//			if(dto.getAddress() != null) {
//				AddressDTO addressDto = dto.getAddress();
//				
//				if(addressDto.getStreet() != null)
//				{
//					address.setStreet(addressDto.getStreet());
//				}
//				
//				if(addressDto.getZipCode() != null)
//				{
//					address.setZipCode(addressDto.getZipCode());
//				}
//				
//				if(addressDto.getCity() != null && addressDto.getCity().getCityId() != null)
//				{
//					City city = cityRepository.findById(addressDto.getCity().getCityId()).orElseThrow(() -> new RuntimeException("City not found"));
//					
//					address.setCity(city);
//					
//				} 
//				
//				if (addressDto.getCreatedBy() != null) {
//	                address.setCreatedBy(addressDto.getCreatedBy());
//	            }
//				
//			}
//			userRepository.save(user);
//			return user;
//			
//		}
//		else {
//	        throw new RuntimeException("User not found");
//	    }
//   }
	
	public User partialUpdateUserById(Long id, UpdateUserDTO dto) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent())
		{
			User user = optionalUser.get();
			Address address = user.getAddress();
		
		
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		AddressDTO addressDTO = dto.getAddress();
		address.setStreet(addressDTO.getStreet());
		address.setZipCode(addressDTO.getZipCode());
		
		City city = cityRepository.findById(addressDTO.getCity().getCityId()).orElseThrow(() -> new RuntimeException("City is not Found"));
		address.setCity(city);
		userRepository.save(user);
		return user;
		
		}
		else {
	        throw new RuntimeException("User not found");
	    }
		
		
	}
	
	
		
}

