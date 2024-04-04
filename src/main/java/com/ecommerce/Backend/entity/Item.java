package com.ecommerce.Backend.entity;

import com.ecommerce.Backend.entity.abstractions.ItemAbstract;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class Item extends ItemAbstract {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Getter
  @Setter
  private long item_id;

  @Column(name = "name")
  @Getter
  @Setter
  private String name;

  @Column(name = "test")
  @Getter
  @Setter
  private String test;

  @Override
  public String toString() {
    return String.format("%f (name: %s, test: %s)", item_id, name, test);
  }
}
