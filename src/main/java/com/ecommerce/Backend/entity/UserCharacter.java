package com.ecommerce.Backend.entity;

import java.util.List;
import java.util.UUID;

import com.ecommerce.Backend.entity.abstractions.CharacterObject;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table
public class UserCharacter extends CharacterObject {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID character_id;

  @Column(name = "hitpoints")
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

  @NonNull
  @ManyToOne
  private Account account;

  @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
  private List<Item> items;

}
