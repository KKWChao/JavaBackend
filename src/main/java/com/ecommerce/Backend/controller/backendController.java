package com.ecommerce.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Backend.entity.Account;
import com.ecommerce.Backend.service.AccountService;

@RestController
public class backendController {
  private AccountService accountService;

  @Autowired
  public backendController(AccountService accountService) {
    this.accountService = accountService;
  }

  // Account Routing
  @PostMapping("/register")
  public ResponseEntity<Account> registerAccount() {
    return null;
  }

  @PostMapping("/login")
  public ResponseEntity<Account> loginAccount() {
    return null;
  }

  // Character Routing


  // Item Routing
}
