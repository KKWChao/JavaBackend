package com.ecommerce.Backend.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.Backend.entity.Item;
import com.ecommerce.Backend.service.ItemService;

import lombok.NonNull;

@RestController
public class ItemController {
  private final ItemService itemService;

  @Autowired
  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  /* ITEM ROUTERS */
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
