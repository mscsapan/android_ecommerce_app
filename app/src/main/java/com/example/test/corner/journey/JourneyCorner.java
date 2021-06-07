package com.example.test.corner.journey;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class JourneyCorner extends AppCompatActivity {
    private RecyclerView jRecyclerView;
    private int [] images;
    private List<JourneyModel> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey_corner);
        this.setTitle("Journey Corner");
    }

    @Override
    protected void onStart() {
        super.onStart();
        getJourneyElement();
    }

    private void getJourneyElement() {
        jRecyclerView = findViewById(R.id.journey_main_recycler_view);
        models = new ArrayList<>();
        models.add(new JourneyModel(R.drawable.jp1,"Title: "+"Macbook Pro","MB353","2000 BDT"));
        models.add(new JourneyModel(R.drawable.jp1,"Title: "+"Macbook Pro","MB353","2000 BDT"));
        models.add(new JourneyModel(R.drawable.jp1,"Title: "+"Macbook Pro","MB353","2000 BDT"));
        models.add(new JourneyModel(R.drawable.macbook,"Title: "+"Macbook Pro","MB353","2000 BDT"));
        models.add(new JourneyModel(R.drawable.jp1,"Title: "+"Macbook Pro","MB353","2000 BDT"));
        models.add(new JourneyModel(R.drawable.macbook,"Title: "+"Macbook Pro","MB353","2000 BDT"));
        models.add(new JourneyModel(R.drawable.macbook,"Title: "+"Macbook Pro","MB353","2000 BDT"));
        JourneyCornerAdapter jAdapter = new JourneyCornerAdapter(this,models);
        jRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        jRecyclerView.setAdapter(jAdapter);
        jAdapter.setJourneyOnClickListener(new JourneyCornerAdapter.JourneyOnClickListener() {
            @Override
            public void setJourneyOnClickListener(int position) {
                Toast.makeText(JourneyCorner.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}