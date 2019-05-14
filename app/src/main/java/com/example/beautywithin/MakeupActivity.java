package com.example.beautywithin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MakeupActivity extends AppCompatActivity {
    @BindView(R.id.listView) ListView mListView;

    private String[] makeups = new String[] {"All Day Luminous Foundation","Stunna Lip Paint", "Better Than Love Mascara", "All Nighter Setting Spray","Studio Fix Longwear Foundation","Infallible Proglow Foundation", "Telepathy Super Shock Shadow","Teint Idole Foundation","Bad Gal Bang Mascara","Translucent Setting Powder","Shape Tape Concealer"};
    private String[] brands = new String[]{"Nars","Fenty Beauty","Two Faced","Urban Decay","MAC Cosmetics","L'Oreal Paris","ColorPop Cosmetics","Lancome","Benefit Cosmetics","Laura Mercier","Tarte Cosmetics"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);

        ButterKnife.bind(this);

        MakeupArrayAdapter adapter = new  MakeupArrayAdapter(this, android.R.layout.simple_list_item_1,makeups,brands );
        mListView.setAdapter(adapter);




    }
}
