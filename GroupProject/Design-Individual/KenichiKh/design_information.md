In this UML Class diagram depending on the given requirement and added these classes.
1. "User". This class represents the employee or the user of this app. User will have userId, userName, userPassword and userEmail as attributes while the user will be able to search, or manage using these methods: 
[+addProduct(p: Product): void
+editProduct(p: Product): void
+deleteProduct(p: Product): Void
+searchProducts(searchName: string): List<Product>]

2. "UI". This class is the user interface. Through which a user see a list of store and can connect with any store and complete their necessary work. 
3. "Store". this class is connected with the database so that it can work with all data stored there. it produces a list of products, their price, amount by sqft.
4. Database consist of all the data that can be stored and accessed as necessary.
5. "FloorProduct". In database, this class consist of list of all the products that are for floor.
6. "Product". This class consist of the product name, category, type, brand, amount available, price of each product and color of each product effectively.
7. "Category". This class shows all the different category the product can exist in such as Tile, Stone, Wood, Laminate, Vinyl.
8. "Type". This class shows different type of each product such as porcelain (tile), Ceramic (tile), Resin (tile), Marble (stone), pebble (stone), slate (stone), solid (wood), Engineered (wood), Bambo (wood), Regular (Laminate), Water Resistant (Laminate, Vinyl), and Waterproof (Vinyl) etc.
9. "Species". This class shows the species of woods there is such as Oak, Maple, Hickory.

In this diagram, the user can search by name and get any information on any product depending on the store they are looking through.
