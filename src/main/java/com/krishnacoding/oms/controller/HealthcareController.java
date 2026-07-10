package com.krishnacoding.oms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oms")
public class HealthcareController {

    @GetMapping("/health")
    public String health() {
        return "Order Management Service is up and running!";
    }
}
