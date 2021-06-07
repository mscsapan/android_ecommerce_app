package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PaymentMode extends AppCompatActivity implements View.OnClickListener {
    CardView paymentVisa;
    CardView paymentMasterCard;
    CardView paymentAmericanExpress;
    CardView paymentBrackbank;
    CardView paymentNexus;
    CardView paymentCityBank;
    CardView paymentFastCash;
    CardView paymentPayza;
    CardView paymentMyCash;
    CardView paymentTCash;
    CardView paymentSureCash;
    CardView paymentRocket;
    CardView paymentbKash;
    CardView paymentNagod;
    CardView paymentMCash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_mode);
        this.setTitle("Payment");

    }

    @Override
    protected void onStart() {
        super.onStart();

        findViewById(R.id.payment_visa_card).setOnClickListener(this);
        findViewById(R.id.payment_master_card).setOnClickListener(this);
        findViewById(R.id.payment_american_express).setOnClickListener(this);
        findViewById(R.id.payment_brack_bank).setOnClickListener(this);
        findViewById(R.id.payment_dbbl_nexus).setOnClickListener(this);
        findViewById(R.id.payment_city_bank).setOnClickListener(this);
        findViewById(R.id.payment_fast_cash).setOnClickListener(this);
        findViewById(R.id.payment_payza).setOnClickListener(this);
        findViewById(R.id.payment_my_cash).setOnClickListener(this);
        findViewById(R.id.payment_t_cash).setOnClickListener(this);
        findViewById(R.id.payment_sure_cash).setOnClickListener(this);
        findViewById(R.id.payment_rocket).setOnClickListener(this);
        findViewById(R.id.payment_b_kash).setOnClickListener(this);
        findViewById(R.id.payment_nagod).setOnClickListener(this);
        findViewById(R.id.payment_m_cash).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.payment_visa_card:
                Toast.makeText(this, "Visa Card", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_master_card:
                Toast.makeText(this, "Master Card", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_american_express:
                Toast.makeText(this, "American Express", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_brack_bank:
                Toast.makeText(this, "Brack bank", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_dbbl_nexus:
                Toast.makeText(this, "Nexus", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_city_bank:
                Toast.makeText(this, "City Bank", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_fast_cash:
                Toast.makeText(this, "Fast Cash", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_payza:
                Toast.makeText(this, "Payza", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_my_cash:
                Toast.makeText(this, "My Cash", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_t_cash:
                Toast.makeText(this, "T Cash", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_sure_cash:
                Toast.makeText(this, "Sure Cash", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_rocket:
                Toast.makeText(this, " Dutch Bangla Rocket", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_b_kash:
                startActivity(new Intent(PaymentMode.this, LoadingScreen.class));
                break;
            case R.id.payment_nagod:
                Toast.makeText(this, "Nagod", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment_m_cash:
                Toast.makeText(this, "M Cash", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}