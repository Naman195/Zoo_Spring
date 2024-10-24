package com.naman.zoo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naman.zoo.UserDTO.UpdateUserDTO;
import com.naman.zoo.UserDTO.UserResponse;
import com.naman.zoo.entities.Credentials;
import com.naman.zoo.entities.User;
import com.naman.zoo.models.JwtRequest;
import com.naman.zoo.models.JwtResponse;
import com.naman.zoo.security.JwtHelper;
import com.naman.zoo.services.UserService;

//@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class UserController {
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Autowired
    private AuthenticationManager manager;
	
	@Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

        this.doAuthenticate(request.getUserName(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .JwtToken(token)
                .userName(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	
	private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }
	
	@ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
	
	@PostMapping("/create")
	public ResponseEntity<?>  createUser(@RequestBody User user) {
		
		try {
	        userService.createUser(user);
	        return ResponseEntity.status(HttpStatus.CREATED).body("User SuccessFully Created");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User creation failed.");
	    }

	}
	
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id)
	{
		User user =  userService.getUserById(id);
		if(user.isArchieved()) {
			return ResponseEntity.status(404).body("User NOt Found");
		}
		return ResponseEntity.ok().body(user);
	}
	
	
	@PutMapping("/update/{id}")
	public User updateUserById(@RequestBody User user, @PathVariable Long id)
	{
		return userService.UpdateUserById(user, id);
	}
	
	@PatchMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "User Deleted SuccessFully";
	}
//	@CrossOrigin("http://localhost:3000")
//	@PostMapping("/login")
//	public UserResponse LoginUser(@RequestBody Credentials cred ){
//		
//		return userService.LoginUser(cred.getUsername(), cred.getPassword());
//	}
	
	@PatchMapping("/userupdate/{id}")
	public ResponseEntity<User> partialUpdate(@PathVariable Long id, @RequestBody UpdateUserDTO updateUser) {
		try {
			User updatedUser = userService.partialUpdateUserById(id, updateUser);
			return ResponseEntity.ok(updatedUser);
		} catch (RuntimeException  e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	
	
}
