package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.test.corner.electronics.ElectronicsCorner;
import com.example.test.corner.female.FemaleCorner;
import com.example.test.corner.furniture.FurnitureCorner;
import com.example.test.corner.journey.JourneyCorner;
import com.example.test.corner.kids.KidsCorner;
import com.example.test.corner.male.MaleCorner;

public class ItemCardView extends AppCompatActivity implements View.OnClickListener {
    CardView kidsCorner, maleCorner, femaleCorner, electricCorner, furnitureCorner, journeyCorner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_card_view);
        this.setTitle("Selection Activity");

    }

    @Override
    protected void onStart() {
        super.onStart();
        findViewById(R.id.kids_corner).setOnClickListener(this);
        findViewById(R.id.male_corner).setOnClickListener(this);
        findViewById(R.id.female_corner).setOnClickListener(this);
        findViewById(R.id.electronics_corner).setOnClickListener(this);
        findViewById(R.id.furniture_corner).setOnClickListener(this);
        findViewById(R.id.journey_corner).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kids_corner:
                //Toast.makeText(this, "Kids Corner", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ItemCardView.this, KidsCorner.class));
                break;
            case R.id.male_corner:
                //Toast.makeText(this, "Male Corner", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ItemCardView.this, MaleCorner.class));
                break;
            case R.id.female_corner:
                //Toast.makeText(this, "Female Corner", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ItemCardView.this, FemaleCorner.class));
                break;
            case R.id.furniture_corner:
                //Toast.makeText(this, "Furniture Corner", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ItemCardView.this, FurnitureCorner.class));
                break;
            case R.id.electronics_corner:
                //Toast.makeText(this, "Electronics Corner", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ItemCardView.this, ElectronicsCorner.class));
                break;
            case R.id.journey_corner:
                //Toast.makeText(this, "Journey Corner", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ItemCardView.this, JourneyCorner.class));
                break;
        }
    }
}