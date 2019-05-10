package com.example.beautywithin;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static  int SPLASH_TIME_OUT = 4000 ;
    private Button mmakeupButton;
    private Button mskincareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mmakeupButton = (Button) findViewById(R.id.makeupButton);
        mmakeupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MakeupActivity.class);
                startActivity(intent);
            }
        });

        mskincareButton = (Button) findViewById(R.id.skincareButton);

        new Handler() .postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(homeIntent);
                finish ();


            }
        }, SPLASH_TIME_OUT );
    }
}
