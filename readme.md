# Goal -> Create a spring boot backend for a character creation

### Entities

- Account

  - UUID account_id
  - String email
  - String username
  - String password
  - long characterId (foreign key)[one to many]

- Character (Abstract)

  - Long character_id
  - int hp
  - int mp
  - int atk
  - int matk
  - int def
  - int mdef
  - int str
  - int int
  - int luck
  - int dex
  - List(long inventoryitem) foreign key [many to one]

- InventoryItem

  - Embedded Id
    - Long inventory_id
    - Long item_id
  - quantity

- Items (Abstract)

  - Long item_Id
  - String type
  - int rarity
  - String ability
  - String use
  - String special

- Weapon implements Item
- Potion implements Item
- Armor implements Item

- Account can have multiple characters
- Character can have multiple Items

? enemies?

### Process

1. Create the Entities
2. Create the Service
3. Create the Repository
4. Create the Controller

### Notes

Need to create unit tests then integration tests during each entity/service/controller creation
