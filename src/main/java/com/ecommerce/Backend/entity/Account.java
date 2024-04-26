package com.ecommerce.Backend.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "characters")
@EqualsAndHashCode(callSuper = false, exclude = "characters")
@Table(name = "accounts")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @OneToMany(mappedBy = "account_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<UserCharacter> characters = new ArrayList<>();

  public Account(String email, String username, String password) {
    this.email = email;
    this.username = username;
    this.password = password;
  }

}
