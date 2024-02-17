# Use Case Model

**Author**: Andrew Hu

**Editor**:

## 1 Use Case Diagram

![userCaseDiagram](https://github.com/qc-se-spring23/370Spring23Sec34Team2/blob/main/GroupProject/Docs/usecasediagram.png)

## 2 Use Case Descriptions

<!-- 1 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>View Store Offerings</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>Allows the User to see the inventory of the selected store, which includes the product name, amount of product in stock by square feet, and associated details like color, size, brand, type, price, etc.</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>The User is logged into the system</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>The User can view the inventory of the selected store</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>User logs into the system.</li>
					<li>User selects a store from the Store Fragment.</li>
					<li>The system displays a list of all the stores.</li>
					<li>The User can view the product details for each product in the inventory, including name, amount of product in stock by square feet, color, size, brand, type, price, etc.</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1: The system is unable to display the inventory list due to a server error
				<ol>
				</ol>
				Ex2: The user login credentials are invalid and the system prevents access to the inventory list.
			</td>
		</tr>
	</tbody>
</table>

<!-- 2 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Add Product</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>Allows the User to add new products to the selected Store by filling out the product details such as name, category, material, type and species, and regular or water-resistant.</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>The User is logged into the system</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>A new product is added to the inventory with the provided product details.</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>User logs into the system.</li>
					<li>User selects a store from the Store Fragment.</li>
					<li>User clicks the add button.</li>
					<li>The system prompts the user to enter the product details, including name, category, material, type and species, and regular or water-resistant, color, size, brand, and price.</li>
					<li>The system verifies that the information is correct and adds the product to the store.</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1: The User enters invalid product information, such as an incorrect price or size, and the system prevents the addition of the product.
			</td>
		</tr>
	</tbody>
</table>

<!-- 3 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Edit Product</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>Allows the User to edit the product details such as name, category, material, type and species, and regular or water-resistant for an existing product.</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>The User is logged into the system</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>The product details for the existing product are updated as per the provided information.</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>User logs into the system.</li>
					<li>User selects a store from the Store Fragment.</li>
					<li>User clicks the edit button.</li>
					<li>The system displays the current details of the selected product.</li>
                    			<li>The User updates the necessary fields</li>
					<li>The system verifies that the updated information is correct and saves the changes to the database.</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1: The system is unable to locate the selected product in the store.
			</td>
		</tr>
	</tbody>
</table>

<!-- 4 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Delete Product</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>Allows the User to delete a product from the store.</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
                <td>
                    <ol>
                        <li>The User is logged into the system.</li>
                        <li>An existing product exists in the store.</li>
                    </ol>
                </td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
            <td>The product is removed from the inventory.</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>User logs into the system.</li>
					<li>User selects a store from the Store Fragment.</li>
					<li>User clicks the delete button on the desired product.</li>
					<li>The system removes the product from the store.</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1: The system is unable to locate the selected store.
            <ol>
            </ol>
            Ex2: The User accidentally selects the wrong store.
			</td>
		</tr>
	</tbody>
</table>

<!-- 5 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Search by Name</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>Allows the User to search for a specific product by typing its name in the search bar.</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			    <td>The User is using the system.</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
                <td>The customer can view a list of products based on the name entered in the search bar.</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>User logs into the system.</li>
					<li>User selects a store from the Store Fragment.</li>
					<li>The User enters the name of the product they are looking for in the search bar.</li>
					<li>The system displays a list of products that match the search query.</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1: The system is unable to locate any products that match the search query.
			</td>
		</tr>
	</tbody>
</table>


