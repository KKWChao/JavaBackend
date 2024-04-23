package com.ecommerce.Backend.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.Backend.entity.UserCharacter;
import com.ecommerce.Backend.payload.UserCharacterPayload;
import com.ecommerce.Backend.service.UserCharacterService;

@RestController
public class CharacterController {
  private UserCharacterService userCharacterService;

  @Autowired
  public CharacterController(UserCharacterService userCharacterService) {
    this.userCharacterService = userCharacterService;
  }

  @GetMapping("/characters")
  public ResponseEntity<?> getAllCharacters() {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(userCharacterService.getAllCharacters());
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
  }

  @GetMapping("/character/{character_id}")
  public ResponseEntity<?> getCharacter(@PathVariable UUID character_id) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(userCharacterService.getCharacterById(character_id));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
  }

  @PostMapping("/character")
  public ResponseEntity<?> createCharacter(@RequestBody UserCharacterPayload userCharacterPayload) {
    try {
      return ResponseEntity.status(HttpStatus.OK)
          .body(userCharacterService.addUserCharacter(userCharacterPayload.getCharacter_name(),
              userCharacterPayload.getAccount_id()));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
  }

  @PatchMapping("/character/{character_id}")
  public ResponseEntity<?> updateCharater(@PathVariable UUID character_id,
      @RequestBody Map<String, Object> userCharacter) {
    try {

      return ResponseEntity.status(HttpStatus.OK)
          .body(userCharacterService.updateUserCharacter(character_id, userCharacter));
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
  }

  @DeleteMapping("/character/{character_id}")
  public ResponseEntity<?> deleteCharacter(@PathVariable UUID character_id) {
    try {
      userCharacterService.deleteUserCharacter(character_id);
      return ResponseEntity.status(HttpStatus.OK).body("Character Deleted");
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
  }
}
