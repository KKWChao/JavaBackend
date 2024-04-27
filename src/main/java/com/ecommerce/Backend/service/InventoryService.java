package com.ecommerce.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Backend.entity.InventoryItems;
import com.ecommerce.Backend.repository.InventoryRepository;
import com.ecommerce.Backend.repository.ItemRepository;
import com.ecommerce.Backend.repository.UserCharacterRepository;

@Service
public class InventoryService {
  private final UserCharacterRepository userCharacterRepository;
  private final InventoryRepository inventoryRepository;
  private final ItemRepository itemRepository;

  @Autowired
  public InventoryService(UserCharacterRepository userCharacterRepository, InventoryRepository inventoryRepository,
      ItemRepository itemRepository) {
    this.userCharacterRepository = userCharacterRepository;
    this.inventoryRepository = inventoryRepository;
    this.itemRepository = itemRepository;
  }

  public List<InventoryItems> getInventory(Long inventory_id) {
    // return inventoryRepository.findByInventoryId(inventory_id);
    return null;
  }

  public void addItemToInventory() {

  }

  public void updateItemQuantity() {

  }

  public void removeItem() {

  }
}
