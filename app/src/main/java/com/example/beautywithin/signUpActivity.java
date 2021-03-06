package com.example.beautywithin;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class signUpActivity extends AppCompatActivity {

    @BindView(R.id.signUpButton) Button msignUpButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.intro) TextView mAppNameTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/Beauty.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

        msignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mLocationEditText.getText().toString();

                Toast.makeText(signUpActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(signUpActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }
}
