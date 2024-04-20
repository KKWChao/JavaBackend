package com.ecommerce.Backend.payload;

import lombok.Data;

@Data
public class UserCharacterPayload {
  private String character_name;
  private String account_id;
}
