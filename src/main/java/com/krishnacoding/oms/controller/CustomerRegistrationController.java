package com.krishnacoding.oms.controller;

import com.krishnacoding.oms.dto.RegisterRequest;
import com.krishnacoding.oms.entities.Customer;
import com.krishnacoding.oms.service.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oms/user")
@RequiredArgsConstructor
public class CustomerRegistrationController {

    private final RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody RegisterRequest registerRequest) {
          Customer savedCustomer = registerService.registerCustomer(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }
}



