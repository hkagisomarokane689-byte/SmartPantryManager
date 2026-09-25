package com.example.smartpantrymanager.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.smartpantrymanager.Dao.IngredientDao;
import com.example.smartpantrymanager.entities.PantryItem;

@Database(
        entities = {PantryItem.class},
        version = 1,
        exportSchema = false
)

public abstract class AppDatabase extends RoomDatabase {
    public abstract IngredientDao ingredientdao ();
}
