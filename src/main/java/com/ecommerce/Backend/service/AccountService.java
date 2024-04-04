package com.ecommerce.Backend.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.Backend.entity.Account;
import com.ecommerce.Backend.exception.DuplicateObjectException;
import com.ecommerce.Backend.exception.IncorrectLoginException;
import com.ecommerce.Backend.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountService {

  private final AccountRepository accountRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
    this.accountRepository = accountRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public Account registerAccount(String email, String username, String password) throws DuplicateObjectException {

    if (accountRepository.findByUsername(username).isPresent()) {
      throw new DuplicateObjectException();
    }

    String hashedPassword = passwordEncoder.encode(password);
    Account newAccount = new Account(email, username, hashedPassword);

    return accountRepository.save(newAccount);
  }

  public Account loginAccount(String username, String password) throws IncorrectLoginException, Exception {
    Optional<Account> optionalAccount = accountRepository.findByUsername(username);

    if (!optionalAccount.isPresent()) {
      throw new Exception();
    }

    if (passwordEncoder.matches(password, optionalAccount.get().getPassword())) {
      return optionalAccount.get();
    } else {
      throw new IncorrectLoginException();
    }
  }

  public Account updatedAccount(Account account) throws Exception {

    Optional<Account> optionAccount = accountRepository.findById(account.getaccount_id());

    if (optionAccount.isPresent()) {
      accountRepository.save(account);
    } else {
      throw new Exception();
    }

    return account;
  }

  public void deleteAccount(UUID account_id) {
    accountRepository.deleteById(account_id);
  }
}
