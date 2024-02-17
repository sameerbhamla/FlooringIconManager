package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.qc.seclass.fim.R;

public class AddStoreActivity extends AppCompatActivity {

    EditText name_input, location_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_store);

        name_input = findViewById(R.id.name_input);
        location_input = findViewById(R.id.location_input);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddStoreActivity.this);
                myDB.addStore(name_input.getText().toString().trim(), location_input.getText().toString().trim());

            }
        });
    }
}