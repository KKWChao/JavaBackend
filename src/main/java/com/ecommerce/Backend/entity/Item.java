package com.ecommerce.Backend.entity;

import com.ecommerce.Backend.entity.abstractions.ItemAbstract;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Item extends ItemAbstract {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

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

}
