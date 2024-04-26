package com.ecommerce.Backend.ItemTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ecommerce.Backend.entity.Item;
import com.ecommerce.Backend.repository.ItemRepository;
import com.ecommerce.Backend.service.ItemService;

public class ItemTests {

  @Mock
  private ItemRepository itemRepository;

  @InjectMocks
  private ItemService itemService;

  // @BeforeEach
  // public void setUp() {
  // MockitoAnnotations.openMocks(this);
  // itemService = new ItemService(itemRepository);
  // }

  // private Item createTestItem(UUID itemId, String name, String type, int
  // rarity) {
  // Item testItem = new Item();
  // testItem.setId(itemId);
  // testItem.setName(name);
  // testItem.setType(type);
  // testItem.setRarity(rarity);
  // return testItem;
  // }

  // @Test
  // public void testGetItems() throws Exception {
  // List<Item> items = new ArrayList<>();
  // items.add(createTestItem(UUID.randomUUID(), "Item1", "type1", 1));
  // items.add(createTestItem(UUID.randomUUID(), "Item2", "type2", 2));

  // when(itemService.getItems()).thenReturn(items);

  // List<Item> actualItems = itemService.getItems();
  // assertEquals(items, actualItems);
  // }

  // @Test
  // public void testGetSingleItem() throws Exception {
  // UUID itemId = UUID.randomUUID();
  // Item testItem = createTestItem(itemId, "Item1", "type1", 2);

  // when(itemRepository.findById(itemId)).thenReturn(Optional.of(testItem));

  // Item testGetItem = itemService.getItemById(itemId);
  // assertEquals(testItem, testGetItem);
  // }

  // @Test
  // public void testCreateItem() throws Exception {
  // UUID itemId = UUID.randomUUID();
  // Item testItem = createTestItem(itemId, "Item1", "type1", 2);
  // when(itemRepository.save(testItem)).thenReturn(testItem);
  // when(itemRepository.findById(itemId)).thenReturn(Optional.of(testItem));

  // Optional<Item> retrievedItem = itemRepository.findById(itemId);
  // assertEquals(Optional.of(testItem), retrievedItem);
  // }

  // @Test
  // public void testUpdateItem() throws Exception {
  // UUID itemId = UUID.randomUUID();
  // Item testItem = createTestItem(itemId, "Item1", "type1", 2);
  // when(itemRepository.save(testItem)).thenReturn(testItem);
  // when(itemRepository.findById(itemId)).thenReturn(Optional.of(testItem));

  // }

  // @Test
  // public void testDeleteItem() throws Exception {
  // UUID itemId = UUID.randomUUID();
  // Item testItem = createTestItem(itemId, "Item1", "type1", 2);

  // when(itemRepository.findById(itemId)).thenReturn(Optional.of(testItem));
  // itemService.deleteItemById(itemId);

  // verify(itemRepository).deleteById(itemId);
  // }
}
