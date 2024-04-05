package com.ecommerce.Backend.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Backend.entity.Account;
import com.ecommerce.Backend.entity.Item;
import com.ecommerce.Backend.exception.DuplicateObjectException;
import com.ecommerce.Backend.exception.IncorrectLoginException;
import com.ecommerce.Backend.service.AccountService;
import com.ecommerce.Backend.service.ItemService;

@RestController
public class BackendController {
  private AccountService accountService;
  private ItemService itemService;

  @Autowired
  public BackendController(AccountService accountService, ItemService itemService) {
    this.accountService = accountService;
    this.itemService = itemService;
  }

  /* Account Routing */
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

  /* Character Routing */

  /* Item Routing */
  @GetMapping("/items")
  public ResponseEntity<?> getItems() {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(itemService.getItems());
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
    }
  }

  @GetMapping("/items/{item_id}")
  public ResponseEntity<?> getItem(@NonNull @PathVariable UUID item_id) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(itemService.getItemById(item_id));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }
  }

  @PostMapping("/items")
  public ResponseEntity<?> addItem(@RequestBody Item item) {
    try {
      return ResponseEntity.status(HttpStatus.OK)
          .body(itemService.addItem(item.getName(), item.getType(), item.getRarity()));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(item);
    }
  }

  @PatchMapping("/items/{item_id}")
  public ResponseEntity<?> patchItem(@NonNull @PathVariable UUID item_id, @RequestBody Item item) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(itemService.updateItem(item_id, item));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
  }

  @DeleteMapping("/item/{item_id}")
  public ResponseEntity<?> deleteItem(@NonNull @PathVariable UUID item_id) {
    try {
      itemService.deleteItemById(item_id);
      return ResponseEntity.status(HttpStatus.ACCEPTED).body("Item Deleted");
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
  }
}
