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

    /**
     *
     * @param customerDto - CustomerDto Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    boolean updateAccount(CustomerDto customerDto);




    boolean deleteAccount(String mobileNumber);
}
