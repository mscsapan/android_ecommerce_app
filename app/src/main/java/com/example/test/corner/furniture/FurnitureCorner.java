package com.example.test.corner.furniture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FurnitureCorner extends AppCompatActivity {
    List<FurnitureItemClass> fIClass;
    RecyclerView fRecyclerView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_corner);
        this.setTitle("Furniture Corner");
    }

    @Override
    protected void onStart() {
        super.onStart();
        furniture();
        //navigationView();

    }
    public void furniture(){
        fRecyclerView = findViewById(R.id.furniture_corner_recycler_view);

        fIClass = new ArrayList<>();
        fIClass.add(new FurnitureItemClass(R.drawable.fn1,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn2,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn3,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn4,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn5,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn6,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn7,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn8,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn9,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn10,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn11,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn12,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn13,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn14,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn15,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn16,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn17,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn18,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn19,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));
        fIClass.add(new FurnitureItemClass(R.drawable.fn20,"Title: "+"Door","Price: "+"12000BDT","ID: "+"FN-D10"));

        final FurnitureAdapter fAdapter = new FurnitureAdapter(fIClass, this);

        fRecyclerView.setAdapter(fAdapter);
        fRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fAdapter.setFurnitureClickListener(new FurnitureAdapter.FurnitureClickListener() {
            @Override
            public void furnitureItemListener(int position) {
                Intent fSendIntent = new Intent(FurnitureCorner.this,FurnitureDetails.class);
                fSendIntent.putExtra("fImage",fIClass.get(position).getFurnitureImages());
                fSendIntent.putExtra("fTitle",fIClass.get(position).getFurnitureTitle());
                fSendIntent.putExtra("fPrice",fIClass.get(position).getFurniturePrice());
                fSendIntent.putExtra("fId",fIClass.get(position).getFurnitureId());
                startActivity(fSendIntent);
            }
        });
    }
    public void navigationView(){
        drawerLayout = findViewById(R.id.main_drawer);
        toggle = new ActionBarDrawerToggle((Activity) getApplicationContext(),drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}