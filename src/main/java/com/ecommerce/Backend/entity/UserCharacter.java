package com.ecommerce.Backend.entity;

import java.util.UUID;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.ecommerce.Backend.entity.abstractions.CharacterObject;

import jakarta.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
@Setter
@Entity
@Table(name = "characters")
public class UserCharacter extends CharacterObject {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID character_id;

  @Column(name = "character_name")
  private String character_name;

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

  @Column(name = "luck")
  private int luck;

  @Column(name = "dexterity")
  private int dexterity;

  @Column(name = "account_id")
  private String account_id;

  public UserCharacter() {
  }

  public UserCharacter(String character_name, String account_id) {
    this.character_name = character_name;
    this.account_id = account_id;
  }

  public UserCharacter(String character_name, int character_state, int hit_points, int mana, int attack,
      int magic_attack, int defense, int magic_defense, int strength, int intelligence, int luck, int dexterity) {
    this.character_name = character_name;
    this.character_state = character_state;
    this.hit_points = hit_points;
    this.mana = mana;
    this.attack = attack;
    this.magic_attack = magic_attack;
    this.defense = defense;
    this.magic_defense = magic_defense;
    this.strength = strength;
    this.intelligence = intelligence;
    this.luck = luck;
    this.dexterity = dexterity;
  }

  // @NonNull
  // @ManyToOne
  // private Account account;

  // @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
  // private List<Item> items;

}
