DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS UserCharacters;
DROP TABLE IF EXISTS Items;
DROP TABLE IF EXISTS InventoryItems;

CREATE TABLE accounts (
  id UUID PRIMARY KEY,
  email VARCHAR(255) NOT NULL UNIQUE,
  username VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE UserCharacters (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  character_name VARCHAR(255) UNIQUE NOT NULL,
  account_id UUID NOT NULL,
  character_state INT,
  hit_points INT,
  mana INT,
  attack INT,
  magic_attack INT,
  defense INT,
  magic_defense INT,
  strength INT,
  intelligence INT,
  dexterity INT,
  luck INT
);

CREATE TABLE Items (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  rarity INT NOT NULL,
  ability VARCHAR(255),
  use VARCHAR(255),
  special VARCHAR(255)
);

ALTER TABLE UserCharacters ADD CONSTRAINT fk_account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id);

CREATE TABLE InventoryItems (
  inventory_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  character_id BIGINT,
  item_id BIGINT,
  quantity INT,
  FOREIGN KEY (character_id) REFERENCES UserCharacters(id),
  FOREIGN KEY (item_id) REFERENCES Items(id)
);

