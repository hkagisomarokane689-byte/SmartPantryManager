package com.example.smartpantrymanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.smartpantrymanager.adapters.PantryAdapter;
import com.example.smartpantrymanager.database.DatabaseClient;
import com.example.smartpantrymanager.entities.PantryItem;

import com.example.smartpantrymanager.R;

public class PantryActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();

        List<PantryItem> pantryItems =
                DatabaseClient.getInstance(this)
                        .ingredientDao()
                        .getAllIngredient();
        PantryAdapter adapter =
                new PantryAdapter(pantryItems);

        recyclerView.setAdapter(adapter);
    }

    private RecyclerView recyclerView;
    private Button btnAddIngredient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);

        recyclerView = findViewById(R.id.recyclerView);
        btnAddIngredient = findViewById(R.id.btnAddIngredient);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );
        btnAddIngredient.setOnClickListener(v -> {
            Intent intent = new Intent(
                    PantryActivity.this,
                    AddIngredient.class
            );
            startActivity(intent);
        });
    }
}