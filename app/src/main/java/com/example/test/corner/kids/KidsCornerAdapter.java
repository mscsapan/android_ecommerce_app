package com.example.test.corner.kids;

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

public class KidsCornerAdapter extends RecyclerView.Adapter<KidsCornerAdapter.KidsCorner> {

    Context kContext;
    List<KidsItem> kItems;

    public KidsCornerAdapter(Context kContext, List<KidsItem> kItems) {
        this.kContext = kContext;
        this.kItems = kItems;
    }

    @NonNull
    @Override
    public KidsCorner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kids_corner_layout_design, parent, false);
        return new KidsCorner(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KidsCorner holder, int position) {
        holder.kImageView.setImageResource(kItems.get(position).getKidsImages());
        holder.kTextViewTitle.setText(kItems.get(position).getKidsTitle());
        holder.kTextViewPrice.setText(kItems.get(position).getKidsPrice());
        holder.kTextViewId.setText(kItems.get(position).getKidsId());

    }

    @Override
    public int getItemCount() {
        return kItems.size();
    }

    public static class KidsCorner extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView kImageView;
        TextView kTextViewTitle;
        TextView kTextViewPrice;
        TextView kTextViewId;

        public KidsCorner(@NonNull View itemView) {
            super(itemView);
            kImageView = itemView.findViewById(R.id.kids_corner_image);
            kTextViewTitle = itemView.findViewById(R.id.kids_corner_title);
            kTextViewPrice = itemView.findViewById(R.id.kids_corner_price);
            kTextViewId = itemView.findViewById(R.id.kids_corner_id);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            kidsOnClickListener.kidsItemClickListener(getAdapterPosition());
        }
    }

    public static KidsOnClickListener kidsOnClickListener;

    public interface KidsOnClickListener {
        void kidsItemClickListener(int position);
    }

    public void setKidsOnClickListener(KidsOnClickListener kListener) {
        kidsOnClickListener = kListener;
    }

}
