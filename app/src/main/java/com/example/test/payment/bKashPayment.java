package com.example.test.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.Random;

public class bKashPayment extends AppCompatActivity {
    private TextView paymentInvoice;
    private TextView totalAmount;
    private TextInputLayout phoneNumberEditText;
    private Button confirmButton;
    private Button cancelButton;

    String randomString = "A2uabYtRjj121f547Hg54rF432EfhJ";
    String randomText = "";
    Random random = new Random();
    int length = 8;
    char[] textChar = new char[length];

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_kash_payment);
        this.setTitle("BKash Payment");
    }

    @Override
    protected void onStart() {
        super.onStart();
        randomInvoice();
        confirmButton = findViewById(R.id.bkash_confirm_button);
        phoneNumberEditText = findViewById(R.id.bkash_editText);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = Objects.requireNonNull(phoneNumberEditText.getEditText()).getText().toString().trim();
                if (phoneNumber.isEmpty() || phoneNumber.length()<11){
                    phoneNumberEditText.setErrorEnabled(true);
                    phoneNumberEditText.setError("Enter correct Phone Number.");
                    phoneNumberEditText.requestFocus();
                }else {
                    phoneNumberEditText.setErrorEnabled(false);
                }
            }
        });
    }

    public void randomInvoice(){
        paymentInvoice = findViewById(R.id.payment_invoice);
        for (int i = 0; i < length; i++) {
            textChar[i] = randomString.charAt(random.nextInt(textChar.length));
        }
        for (int i = 0; i < textChar.length; i++) {
            randomText = randomText + textChar[i];
        }
        paymentInvoice.setText("Invoice: "+ randomText);
    }
}