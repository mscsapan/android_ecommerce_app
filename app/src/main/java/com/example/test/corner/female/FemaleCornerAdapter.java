package com.example.test.corner.female;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class FemaleCornerAdapter extends RecyclerView.Adapter<FemaleCornerAdapter.FemaleCorner> {
    Context context;
   List<FemaleModel> femaleModels;

    public FemaleCornerAdapter(Context context, List<FemaleModel> femaleModels) {
        this.context = context;
        this.femaleModels = femaleModels;
    }

    @NonNull
    @Override
    public FemaleCorner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.female_layout_design_recycler, parent, false);
        return new FemaleCorner(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FemaleCorner holder, int position) {
        holder.fImageView.setImageResource(femaleModels.get(position).getfImages());
        holder.fTextViewTitle.setText(femaleModels.get(position).getfTitle());
        holder.fTextViewPrice.setText(femaleModels.get(position).getfPrice());
        holder.fTextViewId.setText(femaleModels.get(position).getfId());

    }

    @Override
    public int getItemCount() {
        return femaleModels.size();
    }

    public static class FemaleCorner extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView fImageView;
        private TextView fTextViewTitle;
        private TextView fTextViewPrice;
        private TextView fTextViewId;

        public FemaleCorner(@NonNull View itemView) {
            super(itemView);
            fImageView = itemView.findViewById(R.id.female_corner_image_view);
            fTextViewTitle = itemView.findViewById(R.id.female_corner_title_text);
            fTextViewPrice = itemView.findViewById(R.id.female_corner_price);
            fTextViewId = itemView.findViewById(R.id.female_corner_product_id);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            femaleOnClickListener.femaleOnItemClickListener(getAdapterPosition());
        }
    }

    public static FemaleOnClickListener femaleOnClickListener;

    public interface FemaleOnClickListener {
        void femaleOnItemClickListener(int position);
    }

    public void setFemaleOnClickListener(FemaleOnClickListener femaleListener) {
        femaleOnClickListener = femaleListener;
    }
}
