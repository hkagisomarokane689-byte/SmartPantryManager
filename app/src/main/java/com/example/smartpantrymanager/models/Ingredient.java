package com.example.smartpantrymanager.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="ingredients")
public class Ingredient {
    private int id;
    private String name;
    private double quantity;
    private String unit;
    private String expiryDate;

    //Empty constructor
    public Ingredient (){

    }
    // Constructor without ID
    public Ingredient (String name, double quantity,String unit, String expirDate){
        this.name=name;
        this.quantity=quantity;
        this.unit=unit;
        this.expiryDate=expiryDate;

    }
//Getters and Setter
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getQuantity(){
        return quantity;
    }
    public void setQuantity(double quantity){
        this.quantity=quantity;
    }
    public String getUnit(){
        return unit;

    }
    public void setUnit(){
        this.unit = unit;
    }
    public String getExpiryDate(){
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate){
        this.expiryDate=expiryDate;
    }
}
