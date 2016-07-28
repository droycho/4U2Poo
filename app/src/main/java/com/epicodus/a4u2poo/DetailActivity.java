package com.epicodus.a4u2poo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.epicodus.a4u2poo.Models.Restroom;
import com.epicodus.a4u2poo.Services.RefugeService;
import com.epicodus.a4u2poo.adapters.RestroomPagerAdapter;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private RestroomPagerAdapter adapterViewPager;
    ArrayList<Restroom> mRestrooms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        mRestrooms = Parcels.unwrap(getIntent().getParcelableExtra("restrooms"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new RestroomPagerAdapter(getSupportFragmentManager(), mRestrooms);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }

}
