package controllers;

import models.Account;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import services.AccountService;

@RestController
@CrossOrigin
@RequestMapping(path="/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @PreAuthorize("#email == authentication.email")
    @RequestMapping(path="/get", method = RequestMethod.GET)
    public Account findByEmail(@RequestParam(name = "email") String email) {
        return accountService.getAccountByEmail(email);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody Account account)
    {
        if (account==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot create null account");
        try {
            return accountService.register(account);
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }


    }

}
