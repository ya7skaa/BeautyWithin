package com.example.beautywithin.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.beautywithin.Constants;
import com.example.beautywithin.R;
import com.example.beautywithin.models.Makeup;
import com.example.beautywithin.ui.MakeupDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseMakeupViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseMakeupViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindMakeup(Makeup makeup) {
        ImageView makeupImageView = (ImageView) mView.findViewById(R.id.makeupImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.makeupNameTextView);
        TextView categoryTextView = (TextView) mView.findViewById(R.id.categoryTextView);
        TextView ratingTextView = (TextView) mView.findViewById(R.id.ratingTextView);

        Picasso.get().load(makeup.getmImageUrl()).into(makeupImageView);

        nameTextView.setText(makeup.getmName());
        categoryTextView.setText(makeup.getmProductCategory());

    }

    @Override
    public void onClick(View view) {
        final ArrayList<Makeup> makeups = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_MAKEUP);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { makeups.add(snapshot.getValue(Makeup.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, MakeupDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("makeups", Parcels.wrap(makeups));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

}
