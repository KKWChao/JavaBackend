package com.ecommerce.Backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Backend.entity.UserCharacter;

@Repository
public interface UserCharacterRepository extends JpaRepository<UserCharacter, UUID> {
}