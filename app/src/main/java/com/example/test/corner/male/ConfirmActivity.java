package com.example.test.corner.male;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;

public class ConfirmActivity extends AppCompatActivity {
    private TextView mTotalItem;
    private TextView mTotalPrice;
    private Button mPaymentOption;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.male_confirm_actiity);
        this.setTitle("Confirmation Order");
    }

    @Override
    protected void onStart() {
        super.onStart();
        maleConfirmation();
    }

    @SuppressLint("SetTextI18n")
    private void maleConfirmation() {
        mTotalItem = findViewById(R.id.male_text_view_total_item);
        mTotalPrice = findViewById(R.id.male_text_view_total_price);
        mPaymentOption = findViewById(R.id.male_confirm_payment);
        mImageView = findViewById(R.id.male_confirm_image_view);
        Intent mIntent = getIntent();

        int image = mIntent.getIntExtra("image",1);
        String totalItem = mIntent.getStringExtra("totalItem");
        String m_price = mIntent.getStringExtra("price");

        mImageView.setImageResource(image);
        mTotalItem.setText("Total Item: "+totalItem);
        mTotalPrice.setText("Total Price: "+m_price);
    }
}