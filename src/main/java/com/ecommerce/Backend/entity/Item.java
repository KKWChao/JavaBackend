package com.ecommerce.Backend.entity;

import java.util.UUID;

import com.ecommerce.Backend.entity.abstractions.ItemAbstract;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table
public class Item extends ItemAbstract {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  public Item() {
  }

  public Item(String name, String type, int rarity) {
    this.name = name;
    this.type = type;
    this.rarity = rarity;
  }

  public Item(String name, String type, int rarity, String ability, String use, String special) {
    this.name = name;
    this.type = type;
    this.rarity = rarity;
    this.ability = ability;
    this.use = use;
    this.special = special;
  }

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;

  @Column(name = "rarity")
  private int rarity;

  @Column(name = "ability")
  private String ability;

  @Column(name = "use")
  private String use;

  @Column(name = "special")
  private String special;

  /* GETTERS AND SETTERS */

  // public UUID getId() {
  // return id;
  // }

  // public void setId(UUID id) {
  // this.id = id;
  // }

  // public String getName() {
  // return name;
  // }

  // public void setName(String name) {
  // this.name = name;
  // }

  // public String getType() {
  // return type;
  // }

  // public void setType(String type) {
  // this.type = type;
  // }

  // public int getRarity() {
  // return rarity;
  // }

  // public void setRarity(int rarity) {
  // this.rarity = rarity;
  // }

  /* OVERRIDES */
  // @Override
  // public String toString() {
  // return String.format("%s (name: %s, test: %s)", id, name, type);
  // }
}
