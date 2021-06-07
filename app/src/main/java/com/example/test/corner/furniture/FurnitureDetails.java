package com.example.test.corner.furniture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;

public class FurnitureDetails extends AppCompatActivity implements View.OnClickListener {
    ImageView fImageView;
    TextView fTextViewTitle;
    TextView fTextViewPrice;
    TextView fTextViewId;
    EditText fEditText;
    private Button pButton, mButton;
    int initial = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.furniture_details_activity);
        this.setTitle("Furniture Details");
    }

    @Override
    protected void onStart() {
        super.onStart();
        fGetData();

        findViewById(R.id.furniture_minus_button).setOnClickListener(this);
        findViewById(R.id.furniture_plus_button).setOnClickListener(this);
        fEditText = findViewById(R.id.furniture_input_edit_text);
        fEditText.setText(String.valueOf(initial));
    }

    void fGetData() {
        fImageView = findViewById(R.id.furniture_details_image_id);
        fTextViewTitle = findViewById(R.id.furniture_details_title);
        fTextViewPrice = findViewById(R.id.furniture_details_price);
        fTextViewId = findViewById(R.id.furniture_details_id);

        Intent fRecIntent = getIntent();
        int images = fRecIntent.getIntExtra("fImage", 1);
        String title = fRecIntent.getStringExtra("fTitle");
        String price = fRecIntent.getStringExtra("fPrice");
        String id = fRecIntent.getStringExtra("fId");

        fImageView.setImageResource(images);
        fTextViewTitle.setText(title);
        fTextViewPrice.setText(price);
        fTextViewId.setText(id);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.furniture_plus_button:
                plusButton();
                break;
            case R.id.furniture_minus_button:
                minusButton();
                break;
        }
    }

    private void plusButton() {
        initial ++;
        String pValue = fEditText.getEditableText().toString().trim();
        if (pValue.isEmpty())
        {
            fEditText.setText(String.valueOf(initial));
        }else {
            int res = Integer.parseInt(pValue) + 1;
            fEditText.setText(String.valueOf(res));
        }
    }

    private void minusButton() {
        initial --;
        String mValue = fEditText.getEditableText().toString().trim();
        if (mValue.isEmpty())
        {
            fEditText.setText(String.valueOf(initial));
        }else {
            int res = Integer.parseInt(mValue) - 1;
            fEditText.setText(String.valueOf(res));
        }
    }
}