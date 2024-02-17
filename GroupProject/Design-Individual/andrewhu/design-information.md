## 1. As a user of the system I want to be able to see each store's offering and the amount of product in stock by square feet.
- Added a class called "Store" that has a list of products and their corresponding stock amount by square feet. The "Product" class contains the attributes such as color, size, brand, type, price, and category.

## 2. The application must allow employees to add new products to the system. As well as delete and edit them.
- Added operations to the "Product" class to allow employees to add new products, delete existing ones, and edit product details.

## 3. The different categories of floors available are tile, stone, wood, laminate and vinyl.
- Added an attribute "category" to the "Product" class with the possible values of tile, stone, wood, laminate, and vinyl.

## 4. The application must contain a database (DB) of floors.
- Added a class called "DB" that contains a list of "Product" objects.

## 5. Users must be able to search for products by picking from a hierarchical list, where the first level is the floor category, and the second level is the floor type.
- Added a hierarchical structure to the "Product" class. The "category" attribute serves as the first level of the hierarchy, and the "type" attribute serves as the second level. Users can search for products by picking from this hierarchical list.

## 6. Users must also be able to specify an item by typing its name (search functionality).
- Added a search functionality to the "Product" class that allows users to search for products by name.

## 7. All floors regardless of their category have an associated color, size, brand, type and price
- Added the attributes "color", "size", "brand", "type", and "price" to the "Product" class.

## 8. Categories tile and stone have different materials they are made of, e.g. Tile - porcelain, ceramic, resin; Stone - marble, pebble, slate
- Added a subclass for the "Tile" and "Stone" categories. Each subclass contains a list of materials they are made of.

## 9. Wood floors have both a type (solid, engineered, bamboo, etc) and species (oak, hickory, maple, etc.)
- Added the attributes "type" and "species" to the "Wood" class.

## 10. Laminate can be regular laminate or water resistant, whereas vinyl can be water resistant or waterproof
- Added a subclass for "Laminate" and "Vinyl". Each subclass contains a list of water-resistant or waterproof options.

## 11. The User Interface (UI) must be intuitive and responsive.
- Not considered because it does not affect the design directly. However, the design aims to be user-friendly and intuitive by providing a hierarchical list for product search and a search functionality by name. The system is also designed to be responsive by efficiently managing the inventory.
