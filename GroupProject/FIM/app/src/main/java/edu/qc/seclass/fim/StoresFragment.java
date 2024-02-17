package edu.qc.seclass.fim;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import edu.qc.seclass.fim.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class StoresFragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> store_id, store_name, store_location;
    StoreAdapter storeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_stores, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        add_button = rootView.findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddStoreActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(getActivity());
        store_id = new ArrayList<>();
        store_name = new ArrayList<>();
        store_location = new ArrayList<>();

        displayData();

        storeAdapter = new StoreAdapter(this.getActivity(), this.store_id, this.store_name, this.store_location);
        recyclerView.setAdapter(storeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));


        storeAdapter.setOnItemClickListener(new StoreAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Create an intent to open the ProductListActivity for the clicked store
                Intent intent = new Intent(getActivity(), ProductListActivity.class);
                intent.putExtra("store_id", store_id.get(position));

                // Start the ProductListActivity
                startActivity(intent);
            }
        });


        return rootView;
    }

    void displayData(){
        Cursor cursor = myDB.readAllStores();
        if(cursor.getCount() == 0){
            Toast.makeText(getContext(), "No data.", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                store_id.add(cursor.getString(0)); //first column
                store_name.add(cursor.getString(1)); //second column
                store_location.add(cursor.getString(2));
            }
        }
    }
}

