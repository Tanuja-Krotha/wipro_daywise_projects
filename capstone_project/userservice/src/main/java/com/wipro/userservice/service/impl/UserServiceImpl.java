package com.wipro.userservice.service.impl;

import java.security.Key;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.userservice.dto.Token;
import com.wipro.userservice.dto.UserDTO;
import com.wipro.userservice.entity.User;
import com.wipro.userservice.exception.ResourceNotFoundException;
import com.wipro.userservice.repo.UserRepository;
import com.wipro.userservice.service.UserService;
import com.wipro.userservice.util.AppConstant;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
		@Autowired
	    private UserRepository userRepository;
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	    @Override
	    public User registerUser(UserDTO userDTO) {
	        if (userRepository.existsByUsername(userDTO.getUsername())) {
	            throw new RuntimeException("Username is already taken");
	        }

	        if (userRepository.existsByEmail(userDTO.getEmail())) {
	            throw new RuntimeException("Email is already in use");
	        }

	        User user = new User();
	        user.setUsername(userDTO.getUsername());
	        user.setEmail(userDTO.getEmail());
	        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
	        user.setAddress(userDTO.getAddress());
	        user.setRole(userDTO.getRole() != null ? userDTO.getRole() : User.Role.CUSTOMER);

	        return userRepository.save(user);
	    }

	    // Update user profile
	    @Override
	    public User updateUser(Long id, UserDTO userDTO) {
	        User existingUser = userRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

	        if (userDTO.getEmail() != null && !userDTO.getEmail().equals(existingUser.getEmail())) {
	            if (userRepository.existsByEmail(userDTO.getEmail())) {
	                throw new RuntimeException("Email is already in use");
	            }
	            existingUser.setEmail(userDTO.getEmail());
	        }

	        if (userDTO.getAddress() != null) {
	            existingUser.setAddress(userDTO.getAddress());
	        }

	        return userRepository.save(existingUser);
	    }

	    // Delete user
	    @Override
	    public void deleteUser(Long id) {
	        User user = userRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	        userRepository.delete(user);
	    }

	    // Get all users
	    @Override
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    // Get user by ID
	    @Override
	    public User getUserById(Long id) {
	        return userRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	    }

	    // Get user by username
	    @Override
	    public User getUserByUsername(String username) {
	        return userRepository.findByUsername(username)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
	    }

	    // Login
	    @Override
	    public Token login(UserDTO userDTO) {
	        User dbUser = userRepository.findByEmail(userDTO.getEmail())
	                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

	        if (passwordEncoder.matches(userDTO.getPassword(), dbUser.getPassword())) {
	            String jwtToken = generateJWTToken(dbUser); // Pass the user object
	            return new Token("Bearer " + jwtToken);
	        }

	        throw new RuntimeException("Invalid email or password");
	    }
	    
	    // JWT generation
	    private String generateJWTToken(User user) {
	        Key key = Keys.hmacShaKeyFor(AppConstant.SECRET.getBytes());

	        return Jwts.builder()
	                .setId("jwtExample")
	                .setSubject(user.getUsername())
	                .claim("id", user.getId()) // Add user ID to claims
	                .claim("email", user.getEmail()) // Add email to claims
	                .claim("role", user.getRole().name()) // Add role to claims
	                .claim("username", user.getUsername()) // Add username to claims
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) // 1 hour
	                .signWith(key)
	                .compact();
	    }

		
	    @Override
	    public User getCurrentUser(String username) {
	        return userRepository.findByUsername(username)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
	    }
	

}
