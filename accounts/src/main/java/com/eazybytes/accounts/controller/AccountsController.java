package com.eazybytes.accounts.controller;


import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api", produces={MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private IAccountService accountService;


    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDto> createNewAccount(@RequestBody CustomerDto customerDto) {

        accountService.createAccount(customerDto);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }




    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber) {



        return null;
    }
}
