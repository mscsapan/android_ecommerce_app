package com.example.test.corner.male;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.test.R;
import com.google.android.material.snackbar.Snackbar;

public class MaleCorner extends AppCompatActivity {
    RecyclerView maleRecyclerView;
    int[] maleImageItem = {
            R.drawable.ts1,
            R.drawable.ts2,
            R.drawable.ts3,
            R.drawable.ts4,
            R.drawable.ts5,
            R.drawable.ts6,
            R.drawable.ts7,
            R.drawable.ts8,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male_corner);
        this.setTitle("Male Corner");
    }

    @Override
    protected void onStart() {
        super.onStart();
        maleRecyclerView = findViewById(R.id.male_corner_recycler);

        final String[] maleItemTitle = getResources().getStringArray(R.array.male_corner_item_title);
        final String[] maleItemPrice = getResources().getStringArray(R.array.male_corner_item_price);
        final String[] maleItemId = getResources().getStringArray(R.array.male_corner_item_id);

        MaleCornerAdapter maleCornerAdapter = new MaleCornerAdapter(this, maleImageItem, maleItemId, maleItemTitle, maleItemPrice);
        maleRecyclerView.setAdapter(maleCornerAdapter);
        maleRecyclerView.setHasFixedSize(true);
        maleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        maleCornerAdapter.setMaleOnClickListener(new MaleCornerAdapter.MaleOnClickListener() {
            @Override
            public void maleOnItemClickListener(int position) {
                Intent mSendIntent = new Intent(MaleCorner.this, MaleDetailsActivity.class);
                mSendIntent.putExtra("maleItemImages", maleImageItem[position]);
                mSendIntent.putExtra("maleItemTitle", maleItemTitle[position]);
                mSendIntent.putExtra("maleItemPrice", maleItemPrice[position]);
                mSendIntent.putExtra("maleItemId", maleItemId[position]);
                startActivity(mSendIntent);
            }
        });
    }
}