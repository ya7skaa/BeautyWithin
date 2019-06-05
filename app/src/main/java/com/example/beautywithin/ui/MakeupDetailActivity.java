package com.example.beautywithin.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.beautywithin.R;
import com.example.beautywithin.adapters.MakeupPagerAdapter;
import com.example.beautywithin.models.Makeup;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MakeupDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private MakeupPagerAdapter adapterViewPager;
    ArrayList<Makeup> mMakeups = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup_detail);
        ButterKnife.bind(this);

        mMakeups = Parcels.unwrap(getIntent().getParcelableExtra("makeups"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new MakeupPagerAdapter(getSupportFragmentManager(), mMakeups);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
