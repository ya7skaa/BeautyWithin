package com.example.beautywithin.ui;
import okhttp3.Call;
import okhttp3.Callback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.beautywithin.MakeupArrayAdapter;
import com.example.beautywithin.adapters.MakeupListAdapter;
import com.example.beautywithin.services.MakeupService;
import com.example.beautywithin.R;
import com.example.beautywithin.models.Makeup;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

public class MakeupActivity extends AppCompatActivity {

    private ArrayList<Makeup> makeups = new ArrayList<>();
    public static final String TAG = MakeupActivity.class.getSimpleName();
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private MakeupListAdapter mAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);

        ButterKnife.bind(this);





    }
    private void getMakeup(Call call ,Response response) {
        final MakeupService makeupService = new MakeupService ();
        MakeupService.makeups(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                makeups = MakeupService.processResults(response);

                MakeupActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new MakeupListAdapter(getApplicationContext(), makeups);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(MakeupActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
