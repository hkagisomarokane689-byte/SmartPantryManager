package com.example.smartpantrymanager.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;


import com.example.smartpantrymanager.Dao.IngredientDao;
import com.example.smartpantrymanager.Dao.RecipeDao;
import com.example.smartpantrymanager.entities.PantryItem;
import com.example.smartpantrymanager.entities.Recipe;

@Database(
        entities = {
                PantryItem.class,
                Recipe.class
        },
        version = 2,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract IngredientDao ingredientDao();

    public abstract RecipeDao recipeDao();
}