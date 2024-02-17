package edu.qc.seclass.fim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import edu.qc.seclass.fim.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AddProductActivity extends AppCompatActivity {

    EditText name_input, color_input, size_input, brand_input, type_input, price_input;
    Button add_button;
    String storeId;
    Spinner category_spinner, material_spinner, species_spinner;
    CheckBox water_resistant_checkbox;

    // HashMap to store the available materials for each category
    HashMap<String, ArrayList<String>> materialsMap;

    HashMap<String, ArrayList<String>> speciesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        name_input = findViewById(R.id.name_input);
        color_input = findViewById(R.id.color_input);
        size_input = findViewById(R.id.size_input);
        brand_input = findViewById(R.id.brand_input);
        type_input = findViewById(R.id.type_input);
        price_input = findViewById(R.id.price_input);
        category_spinner = findViewById(R.id.category_spinner);
        material_spinner = findViewById(R.id.material_spinner);
        species_spinner = findViewById(R.id.species_spinner);
        add_button = findViewById(R.id.add_button);
        water_resistant_checkbox = findViewById(R.id.water_resistant_checkbox);

        // get storeId from Intent
        Intent intent = getIntent();
        storeId = intent.getStringExtra("store_id");

        // Initialize materialsMap
        materialsMap = new HashMap<>();
        materialsMap.put("Tile", new ArrayList<>(Arrays.asList("porcelain", "ceramic", "resin")));
        materialsMap.put("Stone", new ArrayList<>(Arrays.asList("marble", "pebble", "slate")));
        materialsMap.put("Wood", new ArrayList<>(Arrays.asList("oak", "hickory", "maple")));
        materialsMap.put("Laminate", new ArrayList<>());

        speciesMap = new HashMap<>();
        speciesMap.put("Wood", new ArrayList<>(Arrays.asList("Water Resistant", "Not Water Resistant")));

        //category spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category_spinner.setAdapter(adapter);
        category_spinner.setSelection(0);

        // Material spinner
        ArrayAdapter<String> materialAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        materialAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        material_spinner.setAdapter(materialAdapter);

        // species spinner
        ArrayAdapter<String> speciesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        speciesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        species_spinner.setAdapter(speciesAdapter);

        // Update material spinner options when a category is selected
        category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedCategory = category_spinner.getSelectedItem().toString();
                ArrayList<String> materials = materialsMap.get(selectedCategory);
                if (materials != null) {
                    materialAdapter.clear();
                    materialAdapter.addAll(materials);
                    material_spinner.setEnabled(true);

                    // Update species and type spinner options for wood category
                    if (selectedCategory.equals("Wood")) {
                        speciesAdapter.clear();
                        speciesAdapter.addAll(Arrays.asList("solid", "engineered", "bamboo"));
                        species_spinner.setSelection(0);
                        material_spinner.setSelection(0);
                        species_spinner.setEnabled(true);
                    } else {
                        speciesAdapter.clear();
                        speciesAdapter.add("");
                        materialAdapter.add("");
                        species_spinner.setSelection(0);
                        species_spinner.setEnabled(false);
                    }

                    // Enable the water resistant checkbox if the category is Laminate
                    if (selectedCategory.equals("Laminate")) {
                        water_resistant_checkbox.setEnabled(true);
                        material_spinner.setEnabled(false);
                    } else {
                        water_resistant_checkbox.setEnabled(false);
                    }
                } else {
                    materialAdapter.clear();
                    speciesAdapter.clear();
                    material_spinner.setEnabled(false);
                    species_spinner.setEnabled(false);
                    water_resistant_checkbox.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing
            }
        });


        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductDB myDB = new ProductDB(AddProductActivity.this);
                myDB.addProduct(name_input.getText().toString().trim(),
                                color_input.getText().toString().trim(),
                                size_input.getText().toString().trim(),
                                brand_input.getText().toString().trim(),
                                type_input.getText().toString().trim(),
                                price_input.getText().toString().trim(),
                                category_spinner.getSelectedItem().toString(),
                                material_spinner.getSelectedItem().toString(),
                                species_spinner.getSelectedItem().toString(),
                                water_resistant_checkbox.isChecked() ? "Water Resistant" : "Not Water Resistant",
                                storeId);

            }
        });
    }
}
