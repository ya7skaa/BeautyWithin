package com.example.beautywithin.ui;
import okhttp3.Call;
import okhttp3.Callback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.beautywithin.MakeupArrayAdapter;
import com.example.beautywithin.ui.services.MakeupService;
import com.example.beautywithin.R;
import com.example.beautywithin.models.Makeup;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

public class MakeupActivity extends AppCompatActivity {
    @BindView(R.id.listView) ListView mListView;
    private ArrayList<Makeup> makeups = new ArrayList<>();

    private String[] brands = new String[]{"Nars","Fenty Beauty","Two Faced","Urban Decay","MAC Cosmetics","L'Oreal Paris","ColorPop Cosmetics","Lancome","Benefit Cosmetics","Laura Mercier","Tarte Cosmetics"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);

        ButterKnife.bind(this);

        MakeupArrayAdapter adapter = new  MakeupArrayAdapter(this, android.R.layout.simple_list_item_1,brands );
        mListView.setAdapter(adapter);




    }
    private void getMakeup() {
        final MakeupService makeupService = new MakeupService ();
        MakeupService.makeups(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                MakeupActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        String[] makeupNames = new String[makeups.size()];
                        for (int i = 0; i < makeupNames.length; i++) {
                            makeupNames[i] =makeups.get(i).getmProductType();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(MakeupActivity.this,
                                android.R.layout.simple_list_item_1,  makeupNames);
                        mListView.setAdapter(adapter);
                    }


                    });
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
