package com.example.test.corner.electronics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

public class ElectronicsCornerAdapter extends RecyclerView.Adapter<ElectronicsCornerAdapter
        .ElectronicsCorner> {
    public static ElectricListener electricListener;

    Context context;
    int[] electronicsImage;
    String[] electronicsTitle;
    String[] electronicsPrice;
    String[] electronicsId;

    public ElectronicsCornerAdapter(Context context, int[] electronicsImage,
                                    String[] electronicsTitle, String[]
                                            electronicsPrice, String[] electronicsId) {
        this.context = context;
        this.electronicsImage = electronicsImage;
        this.electronicsTitle = electronicsTitle;
        this.electronicsPrice = electronicsPrice;
        this.electronicsId = electronicsId;
    }

    @NonNull
    @Override
    public ElectronicsCorner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.electronics_corner_layout_design,
                parent, false);
        return new ElectronicsCorner(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ElectronicsCorner holder, int position) {
        holder.electronicsImageView.setImageResource(electronicsImage[position]);
        holder.electronicsTextViewTitle.setText(electronicsTitle[position]);
        holder.electronicsTextViewPrice.setText("Price: "+electronicsPrice[position]);
        holder.electronicsTextViewId.setText("ID: " +electronicsId[position]);

    }

    @Override
    public int getItemCount() {
        return electronicsImage.length;
    }

    static class ElectronicsCorner extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView electronicsImageView;
        TextView electronicsTextViewTitle;
        TextView electronicsTextViewPrice;
        TextView electronicsTextViewId;

        public ElectronicsCorner(@NonNull View itemView) {
            super(itemView);
            electronicsImageView = itemView.findViewById(R.id.electronics_corner_item_image);
            electronicsTextViewTitle = itemView.findViewById(R.id.electronics_corner_item_title);
            electronicsTextViewPrice = itemView.findViewById(R.id.electronics_corner_item_price);
            electronicsTextViewId = itemView.findViewById(R.id.electronics_corner_item_id);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int itemPosition = getAdapterPosition();
            electricListener.electricItemListener(itemPosition);

        }
    }
    public interface ElectricListener{
        void electricItemListener(int position);
    }
    public void setElectricListener(ElectricListener eListener){
        ElectronicsCornerAdapter.electricListener = eListener;
    }

}
