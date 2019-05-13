package com.example.beautywithin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MakeupActivity extends AppCompatActivity {
    private ListView mListView;

    private String[] makeups = new String[] {"All Day Luminous Foundation","Stunna Lip Paint", "Better Than Sex", "All Nighter Setting Spray","Studio Fix Longwear Foundation","Infallible Proglow Foundation", "Telepathy Super Shock Shadow"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);

        mListView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,makeups );
        mListView.setAdapter(adapter);




    }
}
