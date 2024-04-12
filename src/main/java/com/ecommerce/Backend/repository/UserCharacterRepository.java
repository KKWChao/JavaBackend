package com.ecommerce.Backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Backend.entity.UserCharacter;

public interface UserCharacterRepository extends JpaRepository<UserCharacter, UUID> {

}
