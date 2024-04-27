package com.ecommerce.Backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Backend.entity.InventoryItems;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItems, Long> {
  List<InventoryItems> findByUserCharacterId(Long character_id);
}
