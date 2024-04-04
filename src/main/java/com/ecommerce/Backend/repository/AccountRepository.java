package com.ecommerce.Backend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Backend.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

  Optional<Account> findByUsernameAndPassword(String username, String password);

  Optional<Account> findByUsername(String username);

}
