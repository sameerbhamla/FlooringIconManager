# Design Information of Floor Supply Stores System
### _Joshua Jonghan Kim_
#
#
1. As a user of the system, You can see each store's stock using searchbyStore method. There is no constrain.

2. But this system must allow employees to add, delete and edit. Therefore, I made User class and added userType and checkType to make constrain to access controlStock where you can manipulate product data.

3. The system has DB to store information of each store and stock. Whole data is in DB and when you have to search or manipulate data, you just access and call the variables and methode in DB using your devices.

4. Users can search for products by floor category, floor type and its name using searchbyOther method in searchStock class.

5. To store name, category, material, color, size, brand, type, species, price, amount, water resistance and water-proof, all the attributes are stored in floorProduct class.

6. There are a few regulations for floorProduct attributes. The following rules must be contained when you make real code of floorProduct class. (I thought i don't need to make more complicated structure to realize the rules.)

Tile has porcelain, ceramic, resin materials.
Stone has marble, pebble, slate materials. Other categories has null in material.

Wood floors have solid, engineered, bamboo, etc
types and oak, hickory, maple, etc species. Other categories has null in type.

Laminate may have true in waterResist.

Vinyl may have true in waterResist or waterProof.

