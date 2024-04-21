package com.ecommerce.Backend.payload;

import java.util.UUID;

import lombok.Data;

@Data
public class UserCharacterPayload {
  private String character_name;
  private UUID account_id;
}
