package com.example.test;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.test.fragment.OneFragment;
import com.example.test.fragment.ThreeFragment;
import com.example.test.fragment.TwoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class SuccessActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        tabLayout = findViewById(R.id.tab_layout_id);
        viewPager = findViewById(R.id.view_pager);

        MyViewPager myViewPager = new MyViewPager(getSupportFragmentManager());
        myViewPager.adFragment(new OneFragment(), "Favourite");
        myViewPager.adFragment(new TwoFragment(), "Group");
        myViewPager.adFragment(new ThreeFragment(), "Search");
        viewPager.setAdapter(myViewPager);
        tabLayout.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.favourite);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.group);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.search);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                    case 1:
                    case 2:
                        Toast.makeText(SuccessActivity.this, "" + Objects.requireNonNull(tab.getText()).toString(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}