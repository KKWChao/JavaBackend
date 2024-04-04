package com.ecommerce.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Backend.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
