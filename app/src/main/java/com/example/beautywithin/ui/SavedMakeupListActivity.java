package com.example.beautywithin.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beautywithin.Constants;
import com.example.beautywithin.R;
import com.example.beautywithin.adapters.FirebaseMakeupViewHolder;
import com.example.beautywithin.models.Makeup;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedMakeupListActivity extends AppCompatActivity {

    private DatabaseReference mMakeupReference;
    private FirebaseRecyclerAdapter<Makeup, FirebaseMakeupViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_makeup);
        ButterKnife.bind(this);

        mMakeupReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_MAKEUP);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Makeup> options =
                new FirebaseRecyclerOptions.Builder<Makeup>()
                        .setQuery(mMakeupReference, Makeup.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Makeup, FirebaseMakeupViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseMakeupViewHolder firebaseMakeupViewHolder, int position, @NonNull Makeup makeup) {
                firebaseMakeupViewHolder.bindMakeup(makeup);
            }

            @NonNull
            @Override
            public FirebaseMakeupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.makeup_list_item, parent, false);
                return new FirebaseMakeupViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }

}
