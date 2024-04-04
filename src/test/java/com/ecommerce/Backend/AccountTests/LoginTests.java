package com.ecommerce.Backend.AccountTests;

import static org.mockito.Mockito.*;

import java.io.InvalidClassException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecommerce.Backend.entity.Account;
import com.ecommerce.Backend.exception.IncorrectLoginException;
import com.ecommerce.Backend.repository.AccountRepository;
import com.ecommerce.Backend.service.AccountService;

public class LoginTests {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        accountService = new AccountService(accountRepository, passwordEncoder);
    }

    @Test
    public void testLoginSuccess() throws IncorrectLoginException, Exception {
        // Arrange
        String username = "username";
        String password = "password";
        String hashedPassword = "$2a$10$..."; // Mocked hashed password
        Account account = new Account(username, "email@example.com", hashedPassword);
        when(accountRepository.findByUsername(username)).thenReturn(Optional.of(account));
        when(passwordEncoder.matches(password, hashedPassword)).thenReturn(true);

        // Act
        Account loggedInAccount = accountService.loginAccount(username, password);

        // Assert
        Assertions.assertEquals(account, loggedInAccount);
    }

    @Test
    public void testLoginInvalidCredentials() {
        // Arrange
        String username = "username";
        String password = "wrongPassword";
        String hashedPassword = "$2a$10$..."; // Mocked hashed password
        Account account = new Account(username, "email@example.com", hashedPassword);
        when(accountRepository.findByUsername(username)).thenReturn(Optional.of(account));
        when(passwordEncoder.matches(password, hashedPassword)).thenReturn(false);

        // Act & Assert
        Assertions.assertThrows(IncorrectLoginException.class, () -> {
            accountService.loginAccount(username, password);
        });
    }

    // Add more test cases for other scenarios (e.g., account not found, exceptions)
}