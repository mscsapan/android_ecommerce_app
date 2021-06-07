package com.example.test.corner.furniture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.List;

public class FurnitureAdapter extends RecyclerView.Adapter<FurnitureAdapter.FurnitureViewHolder> {
    List<FurnitureItemClass> furnitureItem;
    Context fContext;

    public FurnitureAdapter(List<FurnitureItemClass> furnitureItem, Context fContext) {
        this.furnitureItem = furnitureItem;
        this.fContext = fContext;
    }

    @NonNull
    @Override
    public FurnitureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.furniture_corner_layout_design,parent,false);
        return new FurnitureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FurnitureViewHolder holder, final int position) {
        holder.fImageView.setImageResource(furnitureItem.get(position).getFurnitureImages());
        holder.fTextViewTitle.setText(furnitureItem.get(position).getFurnitureTitle());
        holder.fTextViewPrice.setText(furnitureItem.get(position).getFurniturePrice());
        holder.fTextViewId.setText(furnitureItem.get(position).getFurnitureId());
    }

    @Override
    public int getItemCount() {
        return furnitureItem.size();
    }

    public static class FurnitureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView fImageView;
        TextView fTextViewTitle;
        TextView fTextViewPrice;
        TextView fTextViewId;
        CardView fCardView;

        public FurnitureViewHolder(@NonNull View itemView) {
            super(itemView);
            fImageView = itemView.findViewById(R.id.furniture_corner_item_image);
            fTextViewTitle = itemView.findViewById(R.id.furniture_corner_item_title);
            fTextViewPrice = itemView.findViewById(R.id.furniture_corner_item_price);
            fTextViewId = itemView.findViewById(R.id.furniture_corner_item_id);
            fCardView = itemView.findViewById(R.id.furniture_card_view_id);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            fListener.furnitureItemListener(getAdapterPosition());

        }
    }
    public static FurnitureClickListener fListener;
    public interface FurnitureClickListener{
        void furnitureItemListener(int position);
    }
    public void setFurnitureClickListener(FurnitureClickListener mListener){
        FurnitureAdapter.fListener = mListener;
    }
}
