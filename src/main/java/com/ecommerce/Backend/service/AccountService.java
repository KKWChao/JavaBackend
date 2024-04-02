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

      accountRepository.save(account);
      return account;

    } catch (Exception exception) {
      throw new Exception();
    }
  }

  public Account loginAccount(String username, String password) throws Exception {
    try {
      Optional<Account> optionalAccount = accountRepository.findByUsernameAndPassword(username, password);

      if (optionalAccount.isPresent()) {
        return optionalAccount.get();
      } else {
        throw new Exception();
      }
    } catch (Exception exception) {
      throw new Exception();
    }
  }

  public Account updatedAccount(Account account) throws Exception {
    try {
      Optional<Account> optionAccount = accountRepository.findById(account.getaccount_id());
      if (optionAccount.isPresent()) {
        accountRepository.save(account);
      } else {
        throw new Exception();
      }
      return account;
    } catch (Exception exception) {
      throw new Exception();
    }
  }

  public void deleteAccount(Long account_id) {
    try {
      accountRepository.deleteById(account_id);
    } catch (Exception exception) {
      System.out.println(exception);
    }
  }
}
