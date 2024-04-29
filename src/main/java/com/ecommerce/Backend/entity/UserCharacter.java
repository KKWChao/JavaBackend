package com.ecommerce.Backend.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ecommerce.Backend.entity.abstractions.CharacterObject;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_characters")
public class UserCharacter extends CharacterObject {

  public UserCharacter(String character_name, UUID account_id) {
    this.character_name = character_name;
    this.account_id = account_id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "character_name", unique = true)
  private String character_name;

  @Column(name = "account_id")
  private UUID account_id;

  @Column(name = "character_state")
  private int character_state;

  @Column(name = "hit_points")
  private int hit_points;

  @Column(name = "mana")
  private int mana;

  @Column(name = "attack")
  private int attack;

  @Column(name = "magic_attack")
  private int magic_attack;

  @Column(name = "defense")
  private int defense;

  @Column(name = "magic_defense")
  private int magic_defense;

  @Column(name = "strength")
  private int strength;

  @Column(name = "intelligence")
  private int intelligence;

  @Column(name = "dexterity")
  private int dexterity;

  @Column(name = "luck")
  private int luck;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "inventory_id")
  private List<InventoryItems> inventory = new ArrayList<>();
}
