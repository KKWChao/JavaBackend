package com.ecommerce.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Backend.entity.InventoryItems;
import com.ecommerce.Backend.entity.Item;
import com.ecommerce.Backend.entity.UserCharacter;
import com.ecommerce.Backend.exception.ItemNotFoundException;
import com.ecommerce.Backend.repository.ItemRepository;
import com.ecommerce.Backend.repository.UserCharacterRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemService {
  private final ItemRepository itemRepository;
  private final UserCharacterRepository userCharacterRepository;

  @Autowired
  public ItemService(ItemRepository itemRepository, UserCharacterRepository userCharacterRepository) {
    this.itemRepository = itemRepository;
    this.userCharacterRepository = userCharacterRepository;
  }

  public List<Item> getItems() {
    return itemRepository.findAll();
  }

  public Item getItemById(Long item_id) throws Exception {

    Optional<Item> optionalItem = itemRepository.findById(item_id);

    if (!optionalItem.isPresent()) {
      throw new Exception();
    }

    return optionalItem.get();
  }

  public Item addItem(String name, String type, int rarity) {
    Item newItem = new Item(name, type, rarity);
    return itemRepository.save(newItem);
  }

  public Item updateItem(Long item_id, Item item) throws ItemNotFoundException {
    Item existingiItem = itemRepository.findById(item_id).orElseThrow(() -> new ItemNotFoundException());

    if (existingiItem.getName() != null) {
      existingiItem.setName(item.getName());
    }

    if (existingiItem.getType() != null) {
      existingiItem.setType(item.getType());
    }

    if (existingiItem.getRarity() > 0) {
      existingiItem.setRarity(item.getRarity());
    }

    return itemRepository.save(existingiItem);
  }

  public void deleteItemById(Long item_id) {

    Optional<Item> deletedItem = itemRepository.findById(item_id);

    if (deletedItem.isPresent()) {
      itemRepository.deleteById(item_id);
    }
  }

  /* Character Backpack Items */
  public List<InventoryItems> getUserCharacterItems(Long character_id) throws Exception {
    Optional<UserCharacter> optionUserCharacter = userCharacterRepository.findById(character_id);

    if (!optionUserCharacter.isPresent()) {
      throw new Exception();
    }

    return null;
  }
}
