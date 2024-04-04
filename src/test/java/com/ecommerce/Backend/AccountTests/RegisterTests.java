package com.ecommerce.Backend.AccountTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.ecommerce.Backend.controller.BackendController;
import com.ecommerce.Backend.entity.Account;
import com.ecommerce.Backend.exception.DuplicateObjectException;
import com.ecommerce.Backend.service.AccountService;

@WebMvcTest
public class RegisterTests {
  private final AccountService accountService = mock(AccountService.class);
  private final BackendController backendController = new BackendController(accountService);

  @Test
  public void testRegisterAccount_Success() throws DuplicateObjectException {
    // Arrange
    Account account = new Account("test@example.com", "test_user", "password");
    when(accountService.registerAccount(account.getEmail(), account.getUsername(), account.getPassword()))
        .thenReturn(account);

    // Act
    ResponseEntity<?> response = backendController.registerAccount(account);

    // Assert
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(account, response.getBody());
  }

}