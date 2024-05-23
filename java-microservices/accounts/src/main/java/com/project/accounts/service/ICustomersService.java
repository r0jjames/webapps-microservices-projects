package com.project.accounts.service;

import com.project.accounts.dto.CustomerDetailsDto;

public interface ICustomersService {
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId);
}
