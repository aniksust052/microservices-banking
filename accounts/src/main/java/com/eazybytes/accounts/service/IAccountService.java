package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountService {

    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);


    /**
     *
     * @param mobileNumber
     * @return Account Details based on a given mobile number
     */
    CustomerDto fetchAccountDetails(String mobileNumber);
}
