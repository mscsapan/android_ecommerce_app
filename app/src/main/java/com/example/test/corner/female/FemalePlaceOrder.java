package com.example.test.corner.female;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;

public class FemalePlaceOrder extends AppCompatActivity {
    private Button placeOrder;
    private TextView female_totalItem;
    private TextView female_totalPrice;
    private ImageView female_image_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.female_place_order_activity);
        this.setTitle("Female Order Item");
    }

    @Override
    protected void onStart() {
        super.onStart();
       femaleFunction();
    }

    private void femaleFunction(){
        female_totalItem = findViewById(R.id.female_place_order_text_view_total_item);
        female_totalPrice = findViewById(R.id.female_place_order_text_view_total_price);
        female_image_view = findViewById(R.id.female_place_order_image_view);

        Intent female_intent = getIntent();
        int images = female_intent.getIntExtra("images2",1);
        String total_price = female_intent.getStringExtra("price2");
        String total_item = female_intent.getStringExtra("item2");

        assert total_price != null;
        assert total_item != null;
        int netPrice = Integer.parseInt(total_price) * Integer.parseInt(total_item);

        female_image_view.setImageResource(images);
        female_totalPrice.setText(String.valueOf(netPrice));
        female_totalItem.setText(total_item);

        placeOrder = findViewById(R.id.female_payment_button);
    }
}