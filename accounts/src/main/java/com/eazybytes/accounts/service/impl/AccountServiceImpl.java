package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.CustomerAlreadyExistException;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountRepository;
    private CustomerRepository customerRepository;


    /**
     *
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());

        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer already exists");
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer =  customerRepository.save(customer);

        accountRepository.save(createNewAccount(savedCustomer));
    }




    /**
     *
     * @param customer-Customer Object
     * @return the new account Details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts accounts = new Accounts();
        accounts.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 10000000000L + new Random().nextInt(900000000);

        accounts.setAccountNumber(randomAccNumber);
        accounts.setAccountType(AccountsConstants.SAVINGS);
        accounts.setBranchAddress(AccountsConstants.ADDRESS);

        accounts.setCreatedAt(LocalDateTime.now());
        accounts.setCreatedBy("Anonymous");

        return accounts;
    }




    /**
     * @param mobileNumber
     * @return Account Details based on a given mobile number
     */
    @Override
    public CustomerDto fetchAccountDetails(String mobileNumber) {
        return null;
    }
}
