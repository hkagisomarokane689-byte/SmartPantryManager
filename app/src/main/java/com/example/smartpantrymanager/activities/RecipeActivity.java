package com.example.smartpantrymanager.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpantrymanager.R;
import com.example.smartpantrymanager.adapters.RecipeAdapter;
import com.example.smartpantrymanager.database.DatabaseClient;
import com.example.smartpantrymanager.entities.Recipe;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private RecyclerView recyclerRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recyclerRecipes =
                findViewById(R.id.recyclerRecipes);

        recyclerRecipes.setLayoutManager(
                new LinearLayoutManager(this)
        );

        List<Recipe> recipes =
                DatabaseClient.getInstance(this)
                        .recipeDao()
                        .getAllRecipes();

        RecipeAdapter adapter =
                new RecipeAdapter(recipes);

        recyclerRecipes.setAdapter(adapter);
    }
}