package com.example.test.corner.kids;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;

public class KidsDetails extends AppCompatActivity implements View.OnClickListener {
    ImageView kImage;
    TextView kTitle;
    TextView kPrice;
    TextView kId, kTotalPrice;
    Button plusButton, minusButton;
    EditText inputEditText;
    int initial = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kids_details_activity);
        this.setTitle("Kids Details");
    }

    @Override
    protected void onStart() {
        super.onStart();
        getKidsData();
        buttonFunction();

    }

    @SuppressLint("SetTextI18n")
    public void getKidsData() {
        kImage = findViewById(R.id.kids_details_image_id);
        kTitle = findViewById(R.id.kids_details_title);
        kPrice = findViewById(R.id.kids_details_price);
        kId = findViewById(R.id.kids_details_id);
        kTotalPrice = findViewById(R.id.kids_total_price);

        Intent kRecIntent = getIntent();
        int images = kRecIntent.getIntExtra("images", 1);
        String title = kRecIntent.getStringExtra("title");
        String price = kRecIntent.getStringExtra("price");
        String id = kRecIntent.getStringExtra("id");

        kImage.setImageResource(images);
        kTitle.setText("Title: " + title);
        kPrice.setText("Price: " + price);
        kId.setText("Product Id: " + id);

        kTotalPrice.setText("Total Price: " + price);
    }

    public void buttonFunction() {
        plusButton = findViewById(R.id.kids_plus_button);
        minusButton = findViewById(R.id.kids_minus_button);
        Button orderButton = findViewById(R.id.kids_order_button);
        inputEditText = findViewById(R.id.kids_input_edit_text);

        inputEditText.setText(String.valueOf(initial));

        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        inputEditText.setOnClickListener(this);

        orderButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.kids_plus_button:
                pButton();
                break;
            case R.id.kids_minus_button:
                mButton();
                break;
            case R.id.kids_order_button:
                orderButton();
                break;
        }
    }

    public void pButton() {
        initial++;
        String pv = inputEditText.getText().toString();
        if (pv.equals("")) {
            String pValue = String.valueOf(initial);
            inputEditText.setText(pValue);

        } else {
            int res = Integer.parseInt(pv) + 1;
            inputEditText.setText(String.valueOf(res));

        }

    }

    public void mButton() {
        initial--;
        String mV = inputEditText.getText().toString();
        if (mV.equals("")) {
            inputEditText.setText(mV);
        } else {
            int res = Integer.parseInt(mV) - 1;
            inputEditText.setText(String.valueOf(res));
        }
    }
    public void orderButton(){
        String eText = inputEditText.getEditableText().toString();
        Toast.makeText(this, eText, Toast.LENGTH_SHORT).show();
    }
}