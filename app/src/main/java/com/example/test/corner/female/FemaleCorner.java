package com.example.test.corner.female;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class FemaleCorner extends AppCompatActivity {
    private RecyclerView femaleRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female_corner);
        this.setTitle("Female Corner");
    }

    @Override
    protected void onStart() {
        super.onStart();
        femaleRecycler = findViewById(R.id.female_main_recycler_view);
        getAllList();
        femaleRecycler.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void getAllList() {
        final List<FemaleModel> femaleModels = new ArrayList<>();
        femaleModels.add(new FemaleModel(R.drawable.fm1, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm2, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm3, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm4, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm5, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm6, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm7, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm8, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm9, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm10, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm11, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm12, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm13, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm14, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm15, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm16, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm17, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm18, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm19, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm20, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm21, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm22, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm23, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));
        femaleModels.add(new FemaleModel(R.drawable.fm24, "Title: " + "Female Dress", "Price: " + "2500 BDT", "ID: " + "F-0101"));

        FemaleCornerAdapter fAdapter = new FemaleCornerAdapter(this, femaleModels);
        femaleRecycler.setAdapter(fAdapter);

        fAdapter.setFemaleOnClickListener(new FemaleCornerAdapter.FemaleOnClickListener() {
            @Override
            public void femaleOnItemClickListener(int position) {
                Intent femaleSentIntent = new Intent(FemaleCorner.this, FemaleDetails.class);
                femaleSentIntent.putExtra("image", femaleModels.get(position).getfImages());
                femaleSentIntent.putExtra("title", femaleModels.get(position).getfTitle());
                femaleSentIntent.putExtra("price", femaleModels.get(position).getfPrice());
                femaleSentIntent.putExtra("id", femaleModels.get(position).getfId());
                startActivity(femaleSentIntent);

            }
        });
    }

}