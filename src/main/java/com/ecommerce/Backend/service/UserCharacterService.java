package com.ecommerce.Backend.service;

import java.util.List;
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

  public UserCharacter getCharacterById(UUID character_id) throws Exception {
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
    // newUserCharacter.setAccount(optionalAccount.get());
    return userCharacterRepository.save(newUserCharacter);
  }
}
