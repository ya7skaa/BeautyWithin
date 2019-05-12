package com.example.beautywithin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUpActivity extends AppCompatActivity {
    private Button msignUpButton;
    private EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        msignUpButton = (Button) findViewById(R.id.signUpButton);


        msignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mLocationEditText.getText().toString();

                Toast.makeText(signUpActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                startActivity(intent);

            }
        });
    }
}
