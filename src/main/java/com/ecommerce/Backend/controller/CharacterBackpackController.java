package com.ecommerce.Backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Backend.service.ItemService;
import com.ecommerce.Backend.service.UserCharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class CharacterBackpackController {
  private UserCharacterService userCharacterService;
  private ItemService itemService;

  @Autowired
  public CharacterBackpackController(UserCharacterService userCharacterService, ItemService itemService) {
    this.userCharacterService = userCharacterService;
    this.itemService = itemService;
  }

  @GetMapping("/character/{character_id}/backpack")
  public ResponseEntity<?> getItems() {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(itemService.getItems());
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
    }
  }
}
