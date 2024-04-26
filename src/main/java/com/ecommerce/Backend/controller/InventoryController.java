package com.ecommerce.Backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Backend.service.ItemService;
import com.ecommerce.Backend.service.UserCharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character/{character_id}")
public class InventoryController {
  private UserCharacterService userCharacterService;
  private ItemService itemService;

  @Autowired
  public InventoryController(UserCharacterService userCharacterService, ItemService itemService) {
    this.userCharacterService = userCharacterService;
    this.itemService = itemService;
  }

  @GetMapping("/inventory")
  public ResponseEntity<?> getItems(@PathVariable Long character_id) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(itemService.getUserCharacterItems(character_id));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
    }
  }
}
