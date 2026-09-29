package com.example.smartpantrymanager.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartpantrymanager.R;
import com.example.smartpantrymanager.database.DatabaseClient;
import com.example.smartpantrymanager.entities.PantryItem;


public class AddIngredient extends AppCompatActivity{
    private EditText edtName;
    private EditText edtQuantity;
    private EditText edtUnit;
    private Button btnSave;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_add_ingredient);

        edtName = findViewById(R.id.edtName);
        edtQuantity = findViewById(R.id.edtQuantity);
        edtUnit = findViewById(R.id.edtUnit);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {

            String name = edtName.getText().toString().trim();
            String quantityText = edtQuantity.getText().toString().trim();
            String unit = edtUnit.getText().toString().trim();

            if (name.isEmpty()) {
                edtName.setError("Please enter an ingredient name");
                edtName.requestFocus();
                return;
            }

            if (quantityText.isEmpty()) {
                edtQuantity.setError("Please enter a quantity");
                edtQuantity.requestFocus();
                return;
            }

            if (unit.isEmpty()) {
                edtUnit.setError("Please enter a unit");
                edtUnit.requestFocus();
                return;
            }
            double quantity = Double.parseDouble(quantityText);
            PantryItem item = new PantryItem(
                    name,
                    quantity,
                    unit,
                    ""
            );

            DatabaseClient.getInstance(this)
                    .ingredientDao()
                    .insert(item);
            Toast.makeText(this,
                    "Ingredient Saved",
                    Toast.LENGTH_SHORT).show();

            finish();
        });
    }
}
