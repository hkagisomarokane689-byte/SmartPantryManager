package com.example.smartpantrymanager.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpantrymanager.R;
import com.example.smartpantrymanager.adapters.RecipeAdapter;
import com.example.smartpantrymanager.database.DatabaseClient;
import com.example.smartpantrymanager.entities.PantryItem;
import com.example.smartpantrymanager.entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class SuggestedRecipesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView txtNoRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        recyclerView = findViewById(R.id.recyclerRecipes);
        txtNoRecipes = findViewById(R.id.txtNoRecipes);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        List<PantryItem> pantryItems =
                DatabaseClient.getInstance(this)
                        .ingredientDao()
                        .getAllIngredient();

        List<Recipe> allRecipes =
                DatabaseClient.getInstance(this)
                        .recipeDao()
                        .getAllRecipes();

        List<Recipe> matchingRecipes =
                new ArrayList<>();

        for (Recipe recipe : allRecipes) {

            boolean canMake = true;

            String[] requiredIngredients =
                    recipe.getIngredients().split(",");

            for (String ingredient : requiredIngredients) {

                boolean found = false;

                for (PantryItem pantryItem : pantryItems) {

                    if (pantryItem.getName()
                            .equalsIgnoreCase(
                                    ingredient.trim()
                            )) {

                        found = true;
                        break;
                    }
                }
                if (!found) {
                    canMake = false;
                    break;
                }
            }

            if (canMake) {
                matchingRecipes.add(recipe);
            }
        }

        if (matchingRecipes.isEmpty()) {

            txtNoRecipes.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);

        } else {

            txtNoRecipes.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            RecipeAdapter adapter =
                    new RecipeAdapter(matchingRecipes);

            recyclerView.setAdapter(adapter);
        }
    }
}