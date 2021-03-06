package com.example.beautywithin;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static  int SPLASH_TIME_OUT = 4000 ;
    @BindView(R.id.splash) TextView mAppNameTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/Beauty.ttf");
        mAppNameTextView.setTypeface(ostrichFont);







        new Handler() .postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this,signUpActivity.class);
                startActivity(homeIntent);
                finish ();


            }
        }, SPLASH_TIME_OUT );
    }
}
