package com.example.test.corner.male;

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

public class MaleCornerAdapter extends RecyclerView.Adapter<MaleCornerAdapter.MaleCorner> {
    public static MaleOnClickListener maleOnClickListener;
    Context context;
    int[] maleImage;
    String[] maleItemTitle;
    String[] maleItemPrice;
    String[] maleItemId;

    public MaleCornerAdapter(Context context, int[] maleImage, String[] maleItemId, String[] maleItemTitle, String[] maleItemPrice) {
        this.context = context;
        this.maleImage = maleImage;
        this.maleItemId = maleItemId;
        this.maleItemTitle = maleItemTitle;
        this.maleItemPrice = maleItemPrice;
    }

    @NonNull
    @Override
    public MaleCorner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.male_corner_layout_design, parent, false);
        return new MaleCorner(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MaleCorner holder, int position) {
        holder.maleImageView.setImageResource(maleImage[position]);
        holder.maleTextViewId.setText("ID: "+maleItemId[position]);
        holder.maleTextViewTitle.setText(maleItemTitle[position]);
        holder.maleTextViewPrice.setText("Price: "+maleItemPrice[position]);

    }

    @Override
    public int getItemCount() {
        return maleImage.length;
    }

    static class MaleCorner extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView maleImageView;
        TextView maleTextViewTitle;
        TextView maleTextViewPrice;
        TextView maleTextViewId;

        public MaleCorner(@NonNull View itemView) {
            super(itemView);
            maleImageView = itemView.findViewById(R.id.male_corner_item_image);
            maleTextViewTitle = itemView.findViewById(R.id.male_corner_item_title);
            maleTextViewPrice = itemView.findViewById(R.id.male_corner_item_price);
            maleTextViewId = itemView.findViewById(R.id.male_corner_item_id);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int itemPosition = getAdapterPosition();
            maleOnClickListener.maleOnItemClickListener(itemPosition);
        }
    }

    public interface MaleOnClickListener {
        void maleOnItemClickListener(int position);
    }

    public void setMaleOnClickListener(MaleOnClickListener mOnClick) {
        MaleCornerAdapter.maleOnClickListener = mOnClick;
    }
}
