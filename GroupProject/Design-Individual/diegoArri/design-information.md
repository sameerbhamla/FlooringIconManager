1. As a user of the system I want to be able to see each store's offering and the amount of product 
To realize this requirement, I added an employee class which contains the operation to check a stores amount of product and a productAmount attribute

2. The application must allow employees to add new products to the system. As well as
delete and edit them.
To realize this requirement, I added an add, delete, and edit operation to the employee class

3. The different categories of floors available are tile, stone, wood, laminate and vinyl.
To realize this requirement, I added a category class below the floor class where the several
different categories depend on the category class

4. The application must contain a database (DB) of floors.
To realize this requirement, I added a floor class which will track all the floors

5. Users must be able to search for products by picking from a hierarchical list
To realize this requirement, I created a hiearchy of classes for floors

6. Users must also be able to specify an item by typing its name (search functionality)
To realize this requirement, I created a searchProduct operation for the employee class

7. All floors regardless of their category have an associated color, size, brand, type and
price
To realize this requirement, I added all these attributes to the floor class

8. Categories tile and stone have different materials they are made of, e.g. Tile - porcelain,
ceramic, resin; Stone - marble, pebble, slate
To realize this requirement, I added boolean variables to represent which material the tile and stones are made of

9. Wood floors have both a type (solid, engineered, bamboo, etc) and species (oak,
hickory, maple, etc.)
To realize this requirement, I added a type and a species class that depends on the wood class

10. Laminate can be regular laminate or water resistant, whereas vinyl can be water
resistant or waterproof
To realize this requirement, I added boolean variables to the laminate and vinyl classes
to represent the different kinds of features

11. The User Interface (UI) must be intuitive and responsive.
Not considered because it does not affect the design directly