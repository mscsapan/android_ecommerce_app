package com.example.test.corner.electronics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.test.R;
import com.google.android.material.snackbar.Snackbar;

public class ElectronicsCorner extends AppCompatActivity {
    RecyclerView electronicsRecycler;
    int[] electronicsImage = {
            R.drawable.macbook,
            R.drawable.macbook2,
            R.drawable.macbook3,
            R.drawable.macbook4,
            R.drawable.macbook5,
            R.drawable.macbook6,
            R.drawable.macbook7,
            R.drawable.product1,
            R.drawable.product2,
            R.drawable.product3,
            R.drawable.product4,
    };
    String[] electronicsTitle;
    String[] electronicsPrice;
    String[] electronicsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics_corner);
        this.setTitle("Electronics Corner");
    }

    @Override
    protected void onStart() {
        super.onStart();
        electronicsRecycler = findViewById(R.id.electronics_corner_recycler_view);

        electronicsTitle =
                getResources().getStringArray(R.array.electronics_corner_item_title);
        electronicsPrice = getResources().getStringArray(R.array.electronics_corner_price);
        electronicsId = getResources().getStringArray(R.array.electronics_corner_Id);

        ElectronicsCornerAdapter electronicsCornerAdapter =
                new ElectronicsCornerAdapter(this, electronicsImage,
                        electronicsTitle, electronicsPrice, electronicsId);

        electronicsRecycler.setAdapter(electronicsCornerAdapter);
        electronicsRecycler.setLayoutManager(new LinearLayoutManager(this));
        //electronicsRecycler.setLayoutManager(new GridLayoutManager(this,2));
        electronicsRecycler.setHasFixedSize(true);
        electronicsCornerAdapter.setElectricListener(new ElectronicsCornerAdapter
                .ElectricListener() {
            @Override
            public void electricItemListener(int position) {
                Intent eSendIntent = new Intent(ElectronicsCorner.this, ElectricDetails.class);
                eSendIntent.putExtra("eImages", electronicsImage[position]);
                eSendIntent.putExtra("eTitle", electronicsTitle[position]);
                eSendIntent.putExtra("ePrice", electronicsPrice[position]);
                eSendIntent.putExtra("eId", electronicsId[position]);
                startActivity(eSendIntent);
            }
        });


    }
}