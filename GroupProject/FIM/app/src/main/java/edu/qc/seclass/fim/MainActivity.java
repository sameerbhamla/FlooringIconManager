package edu.qc.seclass.fim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import edu.qc.seclass.fim.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    ProductListFragment productListFragment = new ProductListFragment();
    StoresFragment storesFragment = new StoresFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //when app opens it starts in the stores fragment
        bottomNavigationView.setSelectedItemId(R.id.stores);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, storesFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.stores:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, storesFragment).commit();
                        return true;
                    case R.id.productList:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, productListFragment).commit();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
                        return true;
                }

                return false;
            }
        });

    }
}