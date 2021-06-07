package com.example.test.corner.male;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

public class MaleDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView mImageView;
    TextView mTextViewTitle;
    TextView mTextViewPrice;
    TextView mTextViewId;
    TextView mTotalPrice;
    Button mOrderButton;
    EditText mEditText;
    int initial = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.male_details_activity);
        this.setTitle("Male Details");
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onStart() {
        super.onStart();
        mImageView = findViewById(R.id.male_details_image_id);
        mTextViewTitle = findViewById(R.id.male_details_title);
        mTextViewPrice = findViewById(R.id.male_details_price);
        mTextViewId = findViewById(R.id.male_details_id);

        mTotalPrice = findViewById(R.id.male_total_price);
        findViewById(R.id.male_plus_button).setOnClickListener(this);
        findViewById(R.id.male_minus_button).setOnClickListener(this);
        findViewById(R.id.male_order_button).setOnClickListener(this);
        mEditText = findViewById(R.id.male_input_edit_text);


        Intent mRecIntent = getIntent();
        int mImages = mRecIntent.getIntExtra("maleItemImages", 1);
        String mTitle = mRecIntent.getStringExtra("maleItemTitle");
        String mPrice = mRecIntent.getStringExtra("maleItemPrice");
        String mId = mRecIntent.getStringExtra("maleItemId");

        mImageView.setImageResource(mImages);
        mTextViewTitle.setText("Title: " + mTitle);
        mTextViewPrice.setText("Price: " + mPrice);
        mTextViewId.setText(mId);
        mTotalPrice.setText("Total Price: " + mPrice);

        mEditText.setText(String.valueOf(initial));

        mOrderButton = findViewById(R.id.male_order_button);
        mOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MaleDetailsActivity.this, ConfirmActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.male_plus_button:
                plusButton();
                break;
            case R.id.male_minus_button:
                minusButton();
                break;
        }

    }

    public void plusButton() {
        initial++;
        String plusValue = mEditText.getEditableText().toString().trim();
        if ((plusValue.equals(""))) {
            mEditText.setText(String.valueOf(initial));
        } else {
            int res = Integer.parseInt(plusValue) + 1;
            mEditText.setText(String.valueOf(res));
        }
    }

    public void minusButton() {
        initial--;
        String minusValue = mEditText.getEditableText().toString().trim();
        if (minusValue.equals("")) {
            mEditText.setText(String.valueOf(initial));
        } else {
            int res = Integer.parseInt(minusValue) - 1;
            mEditText.setText(String.valueOf(res));
        }
    }

}