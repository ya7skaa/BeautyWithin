package com.example.beautywithin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MakeupActivity extends AppCompatActivity {

    private String[] makeup = new String[] {"All Day Luminous Foundation","Stunna Lip Paint", "Better Than Sex", "All Nighter Setting Spray","Studio Fix Longwear Foundation","Infallible Proglow Foundation", "Telepathy Super Shock Shadow"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);
    }
}
