package com.example.smartpantrymanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpantrymanager.Dao.RecipeDao;
import com.example.smartpantrymanager.R;
import com.example.smartpantrymanager.adapters.PantryAdapter;
import com.example.smartpantrymanager.database.DatabaseClient;
import com.example.smartpantrymanager.entities.PantryItem;
import com.example.smartpantrymanager.entities.Recipe;

import java.util.List;

public class PantryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btnAddIngredient;
    private Button btnRecipes;
    private Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);

        recyclerView = findViewById(R.id.recyclerView);
        btnAddIngredient = findViewById(R.id.btnAddIngredient);
        btnRecipes = findViewById(R.id.btnRecipes);
        btnSettings = findViewById(R.id.btnSettings);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        RecipeDao recipeDao =
                DatabaseClient.getInstance(this)
                        .recipeDao();

        if (recipeDao.getRecipeCount() == 0) {
            seedRecipes();
        }

        btnAddIngredient.setOnClickListener(v -> {

            Intent intent = new Intent(
                    PantryActivity.this,
                    AddIngredient.class
            );

            startActivity(intent);
        });
        btnRecipes.setOnClickListener(v -> {
            Intent intent = new Intent(
                    PantryActivity.this,
                    RecipeActivity.class
            );
            startActivity(intent);
        });

        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(
                    PantryActivity.this,
                    SettingActivity.class
            );
            startActivity(intent);
        });

    }

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

    private void seedRecipes() {

        RecipeDao dao =
                DatabaseClient.getInstance(this)
                        .recipeDao();

        dao.insert(new Recipe(
                "Tomato Salad",
                "Tomato, Onion, Salt",
                "Chop ingredients and mix together."
        ));

        dao.insert(new Recipe(
                "Scrambled Eggs",
                "Eggs, Butter, Salt",
                "Beat eggs and cook in butter."
        ));

        dao.insert(new Recipe(
                "French Toast",
                "Bread, Eggs, Milk",
                "Dip bread into mixture and fry."
        ));

        dao.insert(new Recipe(
                "Omelette",
                "Eggs, Cheese, Onion",
                "Mix ingredients and fry."
        ));

        dao.insert(new Recipe(
                "Fried Rice",
                "Rice, Eggs, Onion",
                "Cook ingredients together."
        ));

        dao.insert(new Recipe(
                "Tomato Soup",
                "Tomato, Onion, Water",
                "Boil and blend ingredients."
        ));

        dao.insert(new Recipe(
                "Pasta",
                "Pasta, Tomato Sauce",
                "Cook pasta and add sauce."
        ));

        dao.insert(new Recipe(
                "Pancakes",
                "Flour, Eggs, Milk",
                "Mix batter and fry."
        ));

        dao.insert(new Recipe(
                "Fruit Salad",
                "Apple, Banana, Orange",
                "Cut fruit and mix."
        ));

        dao.insert(new Recipe(
                "Grilled Cheese",
                "Bread, Cheese, Butter",
                "Grill until golden."
        ));

        dao.insert(new Recipe(
                "Chicken Curry",
                "Chicken, Onion, Curry Powder",
                "Cook ingredients together."
        ));
        dao.insert(new Recipe(
                "Beef Stew",
                "Beef, Potato, Carrot",
                "Simmer until tender."
        ));

        dao.insert(new Recipe(
                "Mashed Potatoes",
                "Potato, Butter, Milk",
                "Boil and mash potatoes."
        ));

        dao.insert(new Recipe(
                "Rice and Beans",
                "Rice, Beans",
                "Cook and serve together."
        ));

        dao.insert(new Recipe(
                "Burger",
                "Beef Patty, Bun, Lettuce",
                "Cook patty and assemble burger."
        ));

        dao.insert(new Recipe(
                "Chicken Wrap",
                "Chicken, Tortilla, Lettuce",
                "Fill tortilla and wrap."
        ));

        dao.insert(new Recipe(
                "Vegetable Soup",
                "Carrot, Potato, Onion",
                "Boil vegetables until soft."
        ));

        dao.insert(new Recipe(
                "Vegetable Stir Fry",
                "Carrot, Onion, Pepper",
                "Stir fry vegetables until tender."
        ));

        dao.insert(new Recipe(
                "Tuna Sandwich",
                "Tuna, Bread, Mayonnaise",
                "Mix tuna and assemble sandwich."
        ));

        dao.insert(new Recipe(
                "Chicken Sandwich",
                "Chicken, Bread, Lettuce",
                "Cook chicken and assemble sandwich."
        ));
    }

    }