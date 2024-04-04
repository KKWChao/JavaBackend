package com.ecommerce.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Backend.entity.Item;
import com.ecommerce.Backend.repository.ItemRepository;

import jakarta.transaction.Transactional;

// @Service
// @Transactional
// public class ItemService {
// private final ItemRepository itemRepository;

// @Autowired
// public ItemService(ItemRepository itemRepository) {
// this.itemRepository = itemRepository;
// }

// public List<Item> getItems() {
// return itemRepository.findAll();
// }

// }
