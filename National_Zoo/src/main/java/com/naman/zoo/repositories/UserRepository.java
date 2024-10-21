package com.naman.zoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naman.zoo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByuserName(String username);


}
