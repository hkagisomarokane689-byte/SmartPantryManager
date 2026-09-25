package com.example.smartpantrymanager.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.smartpantrymanager.entities.PantryItem;

import java.util.List;

@Dao
public interface IngredientDao{
    @Insert
    void insert(PantryItem item);
    @Update
    void update(PantryItem item);
    @Delete
    void delete(PantryItem item);
    @Query("SELECT * FROM pantry_items")
    List<PantryItem> getAllIngredients();
}

