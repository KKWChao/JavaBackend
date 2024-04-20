package com.ecommerce.Backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

  public UserCharacter getCharacterById(UUID character_id) throws Exception {
    Optional<UserCharacter> optionalUserCharacter = userCharacterRepository.findById(character_id);

    if (!optionalUserCharacter.isPresent()) {
      throw new Exception();
    }

    return optionalUserCharacter.get();
  }

  public UserCharacter addUserCharacter(String character_name, String account_id) {
    UserCharacter newUserCharacter = new UserCharacter(character_name, account_id);
    return userCharacterRepository.save(newUserCharacter);
  }
}
