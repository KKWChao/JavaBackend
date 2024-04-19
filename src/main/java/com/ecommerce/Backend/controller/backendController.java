package com.ecommerce.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.Backend.entity.Account;
import com.ecommerce.Backend.exception.DuplicateObjectException;
import com.ecommerce.Backend.exception.IncorrectLoginException;
import com.ecommerce.Backend.service.AccountService;

@RestController
public class BackendController {
  private AccountService accountService;
  private final CharacterController characterController;
  private final ItemController itemController;

  @Autowired
  public BackendController(AccountService accountService, CharacterController characterController,
      ItemController itemController) {
    this.accountService = accountService;
    this.characterController = characterController;
    this.itemController = itemController;
  }

  /* ACCOUNT ROUTES */
  @PostMapping("/register")
  public ResponseEntity<?> registerAccount(@RequestBody Account account) {
    try {
      Account registerAccount = accountService.registerAccount(account.getEmail(), account.getUsername(),
          account.getPassword());
      return ResponseEntity.status(HttpStatus.OK).body(registerAccount);
    } catch (DuplicateObjectException duplicateObjectException) {
      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User already Exists");
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Client Error");
    }
  }

  @PostMapping("/login")
  public ResponseEntity<?> loginAccount(@RequestBody Account account) {
    try {
      Account loginAccount = accountService.loginAccount(account.getUsername(), account.getPassword());
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginAccount);
    } catch (IncorrectLoginException incorrectLoginException) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect Login");
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Client Error");
    }
  }

  /* CHARACTER ROUTES */
  // @GetMapping("/characters")
  // public ResponseEntity<?> getAllCharacters() {
  // try {
  // return
  // ResponseEntity.status(HttpStatus.OK).body(userCharacterService.getAllCharacters());
  // } catch (Exception exception) {
  // return
  // ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  // }
  // }

  // @GetMapping("/characters/{id}")
  // public ResponseEntity<?> getCharacter(@NonNull @PathVariable UUID
  // character_id) {
  // try {
  // return
  // ResponseEntity.status(HttpStatus.OK).body(userCharacterService.getCharacterById(character_id));
  // } catch (Exception exception) {
  // return
  // ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  // }
  // }

  // @PostMapping("/character")
  // public ResponseEntity<?> createCharacter(@RequestBody UserCharacter
  // userCharacter) {
  // try {
  // return ResponseEntity.status(HttpStatus.OK)
  // .body(userCharacterService.addUserCharacter(userCharacter.getCharacter_name()));
  // } catch (Exception exception) {
  // return
  // ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  // }
  // }
}
