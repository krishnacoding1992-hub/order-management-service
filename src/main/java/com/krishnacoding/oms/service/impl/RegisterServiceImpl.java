package com.krishnacoding.oms.service.impl;

import com.krishnacoding.oms.dto.RegisterRequest;
import com.krishnacoding.oms.entities.Customer;
import com.krishnacoding.oms.entities.User;
import com.krishnacoding.oms.enums.Role;
import com.krishnacoding.oms.exception.DuplicateResourceException;
import com.krishnacoding.oms.repository.CustomerRepository;
import com.krishnacoding.oms.repository.UserRepository;
import com.krishnacoding.oms.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegisterServiceImpl implements RegisterService {

    private final CustomerRepository customerRepository;

    private final UserRepository userRepository;

    @Override
    public Customer registerCustomer(RegisterRequest registerRequest) {
        // Step 1: Validate Email
        if(customerRepository.existsByEmail(registerRequest.getEmail())){
            throw new DuplicateResourceException("Email already exists");
        }

        // Step 2: Validate Username
        if(userRepository.existsByUsername(registerRequest.getUsername())){
            throw new DuplicateResourceException("Username already exists");
        }

        //Create Customer
        Customer  customer = new Customer();
        customer.setName(registerRequest.getName());
        customer.setAddress(registerRequest.getAddress());
        customer.setEmail(registerRequest.getEmail());
        customer.setPhone(registerRequest.getPhone());
        customer.setCity(registerRequest.getCity());
        customer.setState(registerRequest.getState());
        customer.setZipCode(registerRequest.getZipCode());
        customer.setCountry(registerRequest.getCountry());

        //SaveCustomer
        Customer savedCustomer = customerRepository.save(customer);

        //Create User
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setRole(Role.CUSTOMER);
        user.setCustomer(savedCustomer);
        user.setEnabled(true);

        //Save User
        userRepository.save(user);

        return savedCustomer;
    }
}
