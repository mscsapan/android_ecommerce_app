package com.example.test.corner.journey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.List;

public class JourneyCornerAdapter extends RecyclerView.Adapter<JourneyCornerAdapter.JourneyViewHolder> {
    Context jContext;
    List<JourneyModel> models;

    public JourneyCornerAdapter(Context jContext, List<JourneyModel> models) {
        this.jContext = jContext;
        this.models = models;
    }

    @NonNull
    @Override
    public JourneyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(jContext).inflate(R.layout.journey_corner_layout_design, parent, false);
        return new JourneyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JourneyViewHolder holder, int position) {
        holder.jImages.setImageResource(models.get(position).getImages());
        holder.jTextViewTitle.setText(models.get(position).getTitle());
        holder.jTextViewPrice.setText(models.get(position).getPrice());
        holder.jTextViewId.setText(models.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class JourneyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView jImages;
        private TextView jTextViewTitle;
        private TextView jTextViewPrice;
        private TextView jTextViewId;

        public JourneyViewHolder(@NonNull View itemView) {
            super(itemView);
            jImages = itemView.findViewById(R.id.journey_corner_item_image);
            jTextViewTitle = itemView.findViewById(R.id.journey_corner_item_title);
            jTextViewPrice = itemView.findViewById(R.id.journey_corner_item_price);
            jTextViewId = itemView.findViewById(R.id.journey_corner_item_id);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            journeyOnClickListener.setJourneyOnClickListener(getAdapterPosition());
        }
    }

    public static JourneyOnClickListener journeyOnClickListener;

    public interface JourneyOnClickListener {
        void setJourneyOnClickListener(int position);
    }

    public void setJourneyOnClickListener(JourneyOnClickListener jListener) {
        journeyOnClickListener = jListener;
    }
}
