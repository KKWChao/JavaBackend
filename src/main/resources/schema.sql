DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS user_characters;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS inventory_items;

CREATE TABLE accounts (
  id UUID PRIMARY KEY,
  email VARCHAR(255) NOT NULL UNIQUE,
  username VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE user_characters (
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

CREATE TABLE items (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  rarity INT NOT NULL,
  ability VARCHAR(255),
  use VARCHAR(255),
  special VARCHAR(255)
);

ALTER TABLE user_characters ADD CONSTRAINT fk_account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id);

CREATE TABLE inventory_items (
  inventory_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  character_id BIGINT,
  item_id BIGINT,
  quantity INT,
  FOREIGN KEY (character_id) REFERENCES user_characters(id),
  FOREIGN KEY (item_id) REFERENCES items(id)
);

