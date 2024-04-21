package com.ecommerce.Backend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.ecommerce.Backend.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
  // @NonNull
  // Optional<Item> findById(@NonNull UUID id);
}
