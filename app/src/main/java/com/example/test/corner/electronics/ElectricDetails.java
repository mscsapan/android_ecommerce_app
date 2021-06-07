package com.example.test.corner.electronics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;

public class ElectricDetails extends AppCompatActivity implements View.OnClickListener {
    ImageView eImageView;
    TextView eTextViewTitle;
    TextView eTextViewPrice;
    TextView eTextViewId;
    private EditText eEditText;
    private Button PlusButton,mButton;
    int initial = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.electric_details_activity);
        this.setTitle("Electronics Details");
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onStart() {
        super.onStart();
        getElectricData();
        itemFunction();

    }

    private void itemFunction() {
        findViewById(R.id.electric_plus_button).setOnClickListener(this);
        findViewById(R.id.electric_minus_button).setOnClickListener(this);
        eEditText = findViewById(R.id.electric_input_edit_text);

        eEditText.setText(String.valueOf(initial));
    }

    private void getElectricData(){
        eImageView = findViewById(R.id.electric_details_image_id);
        eTextViewTitle = findViewById(R.id.electric_details_title);
        eTextViewPrice = findViewById(R.id.electric_details_price);
        eTextViewId = findViewById(R.id.electric_details_id);

        Intent eRecIntent = getIntent();
        int eImages = eRecIntent.getIntExtra("eImages",1);
        String eTitle = eRecIntent.getStringExtra("eTitle");
        String ePrice = eRecIntent.getStringExtra("ePrice");
        String eId = eRecIntent.getStringExtra("eId");

        eImageView.setImageResource(eImages);
        eTextViewTitle.setText("Title: "+eTitle);
        eTextViewPrice.setText("Price: "+ePrice);
        eTextViewId.setText("ID: "+eId);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.electric_plus_button:
                plusButton();
                break;
            case R.id.electric_minus_button:
                minusButton();
                break;
        }
    }

    private void minusButton() {
        initial --;
        String mValue = eEditText.getEditableText().toString().trim();
        if (mValue.isEmpty())
        {
            eEditText.setText(String.valueOf(initial));
        }else {
            int res = Integer.parseInt(mValue) - 1;
            eEditText.setText(String.valueOf(res));
        }
    }

    private void plusButton() {
        initial ++;
        String pValue = eEditText.getEditableText().toString().trim();
        if (pValue.isEmpty())
        {
            eEditText.setText(String.valueOf(initial));
        }else {
            int res = Integer.parseInt(pValue) + 1;
            eEditText.setText(String.valueOf(res));
        }
    }
}