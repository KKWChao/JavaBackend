package com.ecommerce.Backend.AccountTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecommerce.Backend.controller.BackendController;
import com.ecommerce.Backend.entity.Account;
import com.ecommerce.Backend.exception.DuplicateObjectException;
import com.ecommerce.Backend.repository.AccountRepository;
import com.ecommerce.Backend.service.AccountService;

public class RegisterTests {

  @Mock
  private AccountRepository accountRepository;

  @Mock
  private PasswordEncoder passwordEncoder;

  @InjectMocks
  private AccountService accountService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    accountService = new AccountService(accountRepository, passwordEncoder);
  }

  // need to fix this test
  @Test
  public void testRegisterAccount_Success() throws DuplicateObjectException {
    // Arrange
    String email = "test@test.com";
    String username = "username";
    String password = "password";
    String hashedPassword = "$2a$10$";
    Account account = new Account(email, username, hashedPassword);
    when(accountRepository.save(account)).thenReturn(account);

    // Assert
    // assertEquals(account, registeredAccount);
  }

}
