package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import edu.qc.seclass.fim.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    SearchView search_view;

    ProductDB myDB;
    ArrayList<String> product_id, product_name, product_color, product_size, product_brand, product_type,
            product_price, product_cat, product_mat, product_species, product_water_resistant;
    ProductAdapter productAdapter;

    String storeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        search_view = findViewById(R.id.search_view);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductListActivity.this, AddProductActivity.class);
                intent.putExtra("store_id", storeId);
                startActivity(intent);
            }
        });

        myDB = new ProductDB(ProductListActivity.this);
        product_id = new ArrayList<>();
        product_name = new ArrayList<>();
        product_color = new ArrayList<>();
        product_size = new ArrayList<>();
        product_brand = new ArrayList<>();
        product_type = new ArrayList<>();
        product_price = new ArrayList<>();
        product_cat = new ArrayList<>();
        product_mat = new ArrayList<>();
        product_species = new ArrayList<>();
        product_water_resistant = new ArrayList<>();


        Intent intent = getIntent();
        if (intent != null) {
            storeId = intent.getStringExtra("store_id");
        }

        displayData("");

        productAdapter = new ProductAdapter(ProductListActivity.this, this.product_id, this.product_name,
                this.product_color, this.product_size, this.product_brand, this.product_type,
                this.product_price, this.product_cat, this.product_mat, this.product_species, this.product_water_resistant);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ProductListActivity.this));

        search_view.setOnQueryTextListener(this);
    }

    void displayData(String searchQuery){
        Cursor cursor = myDB.readAllProducts(storeId, searchQuery);
        if(cursor.getCount() == 0){
            Toast.makeText(ProductListActivity.this, "No products for this store.", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                product_id.add(cursor.getString(0));
                product_name.add(cursor.getString(1));
                product_color.add(cursor.getString(2));
                product_size.add(cursor.getString(3));
                product_brand.add(cursor.getString(4));
                product_type.add(cursor.getString(5));
                product_price.add(cursor.getString(6));
                product_cat.add(cursor.getString(7));
                product_mat.add(cursor.getString(8));
                product_species.add(cursor.getString(9));
                product_water_resistant.add(cursor.getString(10));
            }
        }
    }

    public void deleteProduct(int position) {
        productAdapter.deleteProduct(position);
    }

    public void editProduct(int position) {
        // Launch the EditProductActivity and pass in the product ID
        Intent intent = new Intent(this, EditProductActivity.class);
        intent.putExtra("product_id", product_id.get(position));
        startActivity(intent);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        product_id.clear();
        product_name.clear();
        product_color.clear();
        product_size.clear();
        product_brand.clear();
        product_type.clear();
        product_price.clear();
        product_cat.clear();
        product_mat.clear();
        product_species.clear();
        product_water_resistant.clear();
        displayData(query);
        productAdapter.notifyDataSetChanged();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        product_id.clear();
        product_name.clear();
        product_color.clear();
        product_size.clear();
        product_brand.clear();
        product_type.clear();
        product_price.clear();
        product_cat.clear();
        product_mat.clear();
        product_species.clear();
        product_water_resistant.clear();
        displayData(newText);
        productAdapter.notifyDataSetChanged();
        return false;
    }
}