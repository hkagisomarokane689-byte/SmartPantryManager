package com.example.smartpantrymanager.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipes")
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String ingredients;
    private String steps;

    public Recipe(String name,
                  String ingredients,
                  String steps) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public String getIngredients() {
        return ingredients;
    }

    public String getSteps() {
        return steps;
    }
}