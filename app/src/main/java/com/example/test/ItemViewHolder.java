package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.Adapter<ItemViewHolder.ItemViewHolderClass> {
    public static MyListener myListener;

    Context context;
    int[] images;
    String[] name;

    public ItemViewHolder(Context context, int[] images, String[] name) {
        this.context = context;
        this.images = images;
        this.name = name;
    }

    @NonNull
    @Override
    public ItemViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_design, parent, false);
        return new ItemViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolderClass holder, int position) {
        holder.productImage.setImageResource(images[position]);
        holder.productTitle.setText(name[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    static class ItemViewHolderClass extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView productImage;
        TextView productTitle;

        public ItemViewHolderClass(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.item_image_view);
            productTitle = itemView.findViewById(R.id.item_text_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myListener.onItemListen(getAdapterPosition(), v);
        }
    }

    public interface MyListener {
        void onItemListen(int position, View view);
    }

    public void setOnMyListener(MyListener myListener) {
        ItemViewHolder.myListener = myListener;
    }
}
