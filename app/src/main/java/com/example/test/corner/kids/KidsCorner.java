package com.example.test.corner.kids;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class KidsCorner extends AppCompatActivity {
    List<KidsItem> kidsItems;
    RecyclerView kidsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_corner);
        this.setTitle("Kids Corner");
    }

    @Override
    protected void onStart() {
        super.onStart();
        kidsItemList();
    }
    public void kidsItemList(){
        kidsRecycler = findViewById(R.id.kids_corner_recycler_view);
        kidsItems = new ArrayList<>();
        kidsItems.add(new KidsItem(R.drawable.kd1,"Guiter Girl","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd2,"Boy kids in Jeans","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd3,"Baby girl in India tradition","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd4,"Girls in summer cloths","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd5,"Boy in coat pants","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd6,"Girls in ethinic wear style","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd7,"Kids in wedding ceremony","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd8,"Kids in Eid festival","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd9,"Boy in his festival","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd10,"Kids in India tradition","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd11,"Benoli Boy model","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd12,"Girls in India Model","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd13,"India Cloth transparent","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd14,"Bengoli kids with festival wear","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd15,"Bangladeshi traditional panjabi","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd16,"Model Boy","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd17,"Reading Girl","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd18,"Baby girl modeling","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd19,"Baby girl modeling","1250BTD","KD-001FM"));
        kidsItems.add(new KidsItem(R.drawable.kd20,"Baby girl modeling","1250BTD","KD-001FM"));
        KidsCornerAdapter kAdapter = new KidsCornerAdapter(this,kidsItems);
        kidsRecycler.setAdapter(kAdapter);
        kidsRecycler.setLayoutManager(new LinearLayoutManager(this));
        kAdapter.setKidsOnClickListener(new KidsCornerAdapter.KidsOnClickListener() {
            @Override
            public void kidsItemClickListener(int position) {
                Intent kSendIntent = new Intent(KidsCorner.this,KidsDetails.class);
                kSendIntent.putExtra("images",kidsItems.get(position).getKidsImages());
                kSendIntent.putExtra("title",kidsItems.get(position).getKidsTitle());
                kSendIntent.putExtra("price",kidsItems.get(position).getKidsPrice());
                kSendIntent.putExtra("id",kidsItems.get(position).getKidsId());
                startActivity(kSendIntent);
            }
        });

    }
}