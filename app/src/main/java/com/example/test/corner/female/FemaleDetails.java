package com.example.test.corner.female;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;

public class FemaleDetails extends AppCompatActivity implements View.OnClickListener {
    ImageView femaleImage;
    TextView femaleTitle;
    TextView femalePrice;
    TextView femaleId, itemPrice;
    EditText inputEditText;
    private Button female_placeOrderButton;
    int initial = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.female_details_activity);
        this.setTitle("Female Details");
    }

    @Override
    protected void onStart() {
        super.onStart();
        getFemaleData();
    }

    public void getFemaleData() {
        findViewById(R.id.female_plus_button).setOnClickListener(this);
        findViewById(R.id.female_minus_button).setOnClickListener(this);

        femaleImage = findViewById(R.id.female_details_image_id);
        femaleTitle = findViewById(R.id.female_details_title);
        femalePrice = findViewById(R.id.female_details_price);
        femaleId = findViewById(R.id.female_details_id);
        inputEditText = findViewById(R.id.female_input_edit_text);

        inputEditText.setText(String.valueOf(initial));

        Intent femaleRecIntent = getIntent();
        final int images = femaleRecIntent.getIntExtra("image", 1);
        String title = femaleRecIntent.getStringExtra("title");
        final String price = femaleRecIntent.getStringExtra("price");
        String id = femaleRecIntent.getStringExtra("id");

        femaleImage.setImageResource(images);
        femaleTitle.setText(title);
        femalePrice.setText(price);
        femaleId.setText(id);

        female_placeOrderButton = findViewById(R.id.female_order_button);
        female_placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent female = new Intent(FemaleDetails.this, FemalePlaceOrder.class);
                String female_input_text = inputEditText.getText().toString();
                String female_price = femalePrice.toString();
                int res = Integer.parseInt(female_input_text) * Integer.parseInt(female_price);
                female.putExtra("images2", images);
                female.putExtra("price2", price);
                female.putExtra("item2", res);
                startActivity(female);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.female_plus_button:
                plusButton();
                break;
            case R.id.female_minus_button:
                minusButton();
                break;
        }
    }

    private void plusButton() {
        initial++;
        String pValue = inputEditText.getEditableText().toString().trim();
        if (pValue.isEmpty()) {
            inputEditText.setText(String.valueOf(initial));
        } else {
            int res = Integer.parseInt(pValue) + 1;
            inputEditText.setText(String.valueOf(res));
        }
    }

    private void minusButton() {
        initial--;
        String pValue = inputEditText.getEditableText().toString().trim();
        if (pValue.isEmpty()) {
            inputEditText.setText(String.valueOf(initial));
        } else {
            int res = Integer.parseInt(pValue) - 1;
            inputEditText.setText(String.valueOf(res));
        }
    }
}