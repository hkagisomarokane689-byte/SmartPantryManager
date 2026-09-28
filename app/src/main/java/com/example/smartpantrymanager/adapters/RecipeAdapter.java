package com.example.smartpantrymanager.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.content.Intent;
import com.example.smartpantrymanager.activities.RecipeDetailActivity;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpantrymanager.R;
import com.example.smartpantrymanager.entities.Recipe;
import java.util.List;

public class RecipeAdapter
        extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private final List<Recipe> recipes;

    public RecipeAdapter(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(
                parent.getContext()
        ).inflate(
                R.layout.item_recipe,
                parent,
                false
        );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        Recipe recipe = recipes.get(position);

        holder.txtName.setText(recipe.getName());

        holder.txtIngredients.setText(
                "Ingredients: " +
                        recipe.getIngredients()
        );

        holder.txtSteps.setText(
                "Steps: " +
                        recipe.getSteps()
        );
        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(
                    v.getContext(),
                    RecipeDetailActivity.class
            );

            intent.putExtra("name", recipe.getName());
            intent.putExtra("ingredients", recipe.getIngredients());
            intent.putExtra("steps", recipe.getSteps());

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder {

        TextView txtName;
        TextView txtIngredients;
        TextView txtSteps;

        public ViewHolder(View itemView) {
            super(itemView);

            txtName =
                    itemView.findViewById(R.id.txtRecipeName);

            txtIngredients =
                    itemView.findViewById(
                            R.id.txtIngredients
                    );

            txtSteps =
                    itemView.findViewById(
                            R.id.txtSteps
                    );
        }
    }
}