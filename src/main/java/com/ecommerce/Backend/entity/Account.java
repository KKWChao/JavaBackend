package com.ecommerce.Backend.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "accounts")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID account_id;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "character_ids", referencedColumnName = "account_id")
  private Set<UserCharacter> character_id;

  // constructors
  public Account() {
  }

  public Account(String email, String username, String password) {
    this.email = email;
    this.username = username;
    this.password = password;
  }

}
