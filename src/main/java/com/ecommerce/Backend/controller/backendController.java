package com.ecommerce.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Backend.entity.Account;
import com.ecommerce.Backend.exception.DuplicateObjectException;
import com.ecommerce.Backend.exception.IncorrectLoginException;
import com.ecommerce.Backend.service.AccountService;

@RestController
public class BackendController {
  private AccountService accountService;

  @Autowired
  public BackendController(AccountService accountService) {
    this.accountService = accountService;
  }

  // Account Routing
  @PostMapping("/register")
  public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
    try {
      Account registerAccount = accountService.registerAccount(account.getEmail(), account.getUsername(),
          account.getPassword());
      return ResponseEntity.status(HttpStatus.OK).body(registerAccount);
    } catch (DuplicateObjectException duplicateObjectException) {
      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PostMapping("/login")
  public ResponseEntity<Account> loginAccount(@RequestBody Account account) {
    try {
      Account loginAccount = accountService.loginAccount(account.getUsername(), account.getPassword());
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginAccount);
    } catch (IncorrectLoginException incorrectLoginException) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  // Character Routing

  // Item Routing
}
