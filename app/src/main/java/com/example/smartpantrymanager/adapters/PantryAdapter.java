package com.example.smartpantrymanager.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpantrymanager.R;
import com.example.smartpantrymanager.activities.AddIngredient;
import com.example.smartpantrymanager.database.DatabaseClient;
import com.example.smartpantrymanager.entities.PantryItem;

import java.util.List;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.ViewHolder> {

    private final List<PantryItem> items;

    public PantryAdapter(List<PantryItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ingredient, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        PantryItem item = items.get(position);

        holder.txtName.setText(item.getName());

        holder.txtDetails.setText(
                "Quantity: " + item.getQuantity()
                        + " | Unit: " + item.getUnit()
        );

        holder.btnEdit.setOnClickListener(v -> {

            Intent intent = new Intent(
                    v.getContext(),
                    AddIngredient.class
            );

            intent.putExtra("id", item.getId());
            intent.putExtra("name", item.getName());
            intent.putExtra("quantity", item.getQuantity());
            intent.putExtra("unit", item.getUnit());

            v.getContext().startActivity(intent);
        });

        holder.btnDelete.setOnClickListener(v -> {

            DatabaseClient.getInstance(v.getContext())
                    .ingredientDao()
                    .delete(item);

            items.remove(holder.getAdapterPosition());

            notifyItemRemoved(holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        TextView txtDetails;

        Button btnEdit;
        Button btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtDetails = itemView.findViewById(R.id.txtDetails);

            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}