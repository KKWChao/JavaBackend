package com.ecommerce.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Backend.entity.UserCharacter;
import com.ecommerce.Backend.repository.UserCharacterRepository;

@Service
public class UserCharacterService {
  private final UserCharacterRepository userCharacterRepository;

  @Autowired
  public UserCharacterService(UserCharacterRepository userCharacterRepository) {
    this.userCharacterRepository = userCharacterRepository;
  }

  public List<UserCharacter> getAllCharacters() {
    return userCharacterRepository.findAll();
  }
}
