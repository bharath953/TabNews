package com.example.android.tabnews;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(10);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Fragments(),"Headlines");
        adapter.addFragment(new FragmentBusiness(),"Business");
        adapter.addFragment(new Technology(),"Technology");
        adapter.addFragment(new FragmentSports(),"Sports");
        adapter.addFragment(new FragmentEntertainment(),"Entertainment");
        adapter.addFragment(new Science(),"Science");
        adapter.addFragment(new Health(),"Health");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
