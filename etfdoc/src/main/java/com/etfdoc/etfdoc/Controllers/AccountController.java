package com.etfdoc.etfdoc.Controllers;

import com.etfdoc.etfdoc.Models.Account;
import com.etfdoc.etfdoc.Services.AccountService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/account")
public class AccountController {

        private AccountService accountService;

        @Autowired
        public void setAccountService(AccountService accountService){

            this.accountService = accountService;

        }

        @RequestMapping(value = "/get", method = RequestMethod.GET)
        public ResponseEntity getAccountById(@RequestAttribute("id")Long id){

            try{

                return ResponseEntity.status(HttpStatus.OK).
                        body(accountService.getAccountById(id));

            }catch (ServiceException e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(e.getLocalizedMessage());
            }
        }

        @RequestMapping(value = "/getbyemail", method = RequestMethod.GET)
        public ResponseEntity getAccountByEmail(@RequestAttribute("email")String email){

            try{

                return ResponseEntity.status(HttpStatus.OK).
                        body(accountService.getAccountByEmail(email));

            }catch (ServiceException e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(e.getLocalizedMessage());
            }

        }

}
