package com.krishnacoding.oms.service;

import com.krishnacoding.oms.dto.RegisterRequest;
import com.krishnacoding.oms.entities.Customer;

public interface RegisterService {
    Customer registerCustomer(RegisterRequest registerRequest);
}
