package com.example.beautywithin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button mmakeUpButton;
    private Button mskincareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        mmakeUpButton = (Button) findViewById(R.id.makeUpButton);

        mmakeUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MakeupActivity.class);
                startActivity(intent);
            }
        });


        mskincareButton = (Button) findViewById(R.id.skincareButton);
        mskincareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SkincareActivity.class);
                startActivity(intent);
            }
        });



    }
}
