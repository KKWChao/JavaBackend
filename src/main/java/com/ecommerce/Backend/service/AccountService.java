package com.ecommerce.Backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Backend.entity.Account;
import com.ecommerce.Backend.exception.DuplicateObjectException;
import com.ecommerce.Backend.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountService {

  private final AccountRepository accountRepository;
  
  @Autowired
  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account registerAccount(Account account) throws Exception {

    try {
      Optional<Account> optionalAccount = accountRepository.findByUsername(account.getUsername());

      if (optionalAccount.isPresent()) {
        throw new DuplicateObjectException();
      }

    } catch (Exception exception) {
      throw new Exception();
    }
    return null;
    
  }

  public Account loginAccount(String username, String password) {
    return null;
  }

  public Account updatedAccount(Account account) {
    return null;
  }

  public void deleteAccount(Long account_id) {
    
  }
}
