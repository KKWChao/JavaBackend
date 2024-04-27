package com.ecommerce.Backend.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "InventoryItems")
public class InventoryItems {

  @EmbeddedId
  private InventoryItemKey id;

  @ManyToOne
  @MapsId("inventoryId")
  @JoinColumn(name = "character_id")
  private UserCharacter userCharacter;

  @ManyToOne
  @MapsId("itemId")
  @JoinColumn(name = "item_id")
  private Item item;

  private int quantity;

  @Embeddable
  public static class InventoryItemKey implements Serializable {
    @Column(name = "inventory_id")
    private Long inventoryId;

    @Column(name = "item_id")
    private Long itemId;
  }

}
