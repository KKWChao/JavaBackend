package com.ecommerce.Backend.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Backend.entity.Account;
import com.ecommerce.Backend.entity.UserCharacter;
import com.ecommerce.Backend.repository.AccountRepository;
import com.ecommerce.Backend.repository.UserCharacterRepository;

@Service
public class UserCharacterService {
  private final UserCharacterRepository userCharacterRepository;
  private final AccountRepository accountRepository;

  @Autowired
  public UserCharacterService(UserCharacterRepository userCharacterRepository, AccountRepository accountRepository) {
    this.userCharacterRepository = userCharacterRepository;
    this.accountRepository = accountRepository;
  }

  public List<UserCharacter> getAllCharacters() {
    return userCharacterRepository.findAll();
  }

  public UserCharacter getCharacterById(Long character_id) throws Exception {
    Optional<UserCharacter> optionalUserCharacter = userCharacterRepository.findById(character_id);

    if (!optionalUserCharacter.isPresent()) {
      throw new Exception();
    }

    return optionalUserCharacter.get();
  }

  public UserCharacter addUserCharacter(String character_name, UUID account_id) throws Exception {
    Optional<Account> optionalAccount = accountRepository.findById(account_id);

    if (!optionalAccount.isPresent()) {
      throw new Exception();
    }

    UserCharacter newUserCharacter = new UserCharacter(character_name, account_id);
    return userCharacterRepository.save(newUserCharacter);
  }

  public UserCharacter updateUserCharacter(Long character_id, Map<String, Object> userCharacterUpdates)
      throws Exception {
    Optional<UserCharacter> optionalUserCharacter = userCharacterRepository.findById(character_id);

    if (!optionalUserCharacter.isPresent()) {
      throw new Exception();
    }

    UserCharacter existingUserCharacter = optionalUserCharacter.get();

    userCharacterUpdates.forEach((field, value) -> {
      switch (field) {
        case "character_name":
          existingUserCharacter.setCharacter_name((String) value);
          break;
        case "character_state":
          existingUserCharacter.setCharacter_state((Integer) value);
          break;
        case "hit_points":
          existingUserCharacter.setHit_points((Integer) value);
          break;
        case "mana":
          existingUserCharacter.setMana((Integer) value);
          break;
        case "attack":
          existingUserCharacter.setAttack((Integer) value);
          break;
        case "magic_attack":
          existingUserCharacter.setMagic_attack((Integer) value);
          break;
        case "defense":
          existingUserCharacter.setDefense((Integer) value);
          break;
        case "magic_defense":
          existingUserCharacter.setMagic_defense((Integer) value);
          break;
        case "strength":
          existingUserCharacter.setStrength((Integer) value);
          break;
        case "intelligence":
          existingUserCharacter.setIntelligence((Integer) value);
          break;
        case "dexterity":
          existingUserCharacter.setDexterity((Integer) value);
          break;
        case "luck":
          existingUserCharacter.setLuck((Integer) value);
          break;
        // need to figure out how to update backpack
      }
    });

    return userCharacterRepository.save(existingUserCharacter);
  }

  public void deleteUserCharacter(Long character_id) throws Exception {
    Optional<UserCharacter> optionalCharacter = userCharacterRepository.findById(character_id);

    if (!optionalCharacter.isPresent()) {
      throw new Exception();
    }

    userCharacterRepository.deleteById(character_id);
  }
}
