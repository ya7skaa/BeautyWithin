package com.example.beautywithin.adapters;



import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.example.beautywithin.R;
import com.example.beautywithin.models.Makeup;
import com.example.beautywithin.ui.MakeupDetailActivity;
import com.example.beautywithin.util.ItemTouchHelperAdapter;
import com.example.beautywithin.util.OnStartDragListener;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseMakeupListAdapter extends FirebaseRecyclerAdapter<Makeup, FirebaseMakeupViewHolder> implements ItemTouchHelperAdapter {

    private Query mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private ChildEventListener mChildEventListener;
    private ArrayList<Makeup> makeups = new ArrayList<>();

    public FirebaseMakeupListAdapter(@NonNull FirebaseRecyclerOptions<Makeup> options, Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(options);
        this.mRef = ref;
        this.mOnStartDragListener = onStartDragListener;
        this.mContext = context;
        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                makeups.add(dataSnapshot.getValue(Makeup.class));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onBindViewHolder(@NonNull final FirebaseMakeupViewHolder holder, int position, @NonNull Makeup model) {
        holder.bindMakeup(model);
        holder.makeupImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(holder);
                }
                return false;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MakeupDetailActivity.class);
                intent.putExtra("position", holder.getAdapterPosition() + "");
                intent.putExtra("pictures", Parcels.wrap(makeups));

                mContext.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public FirebaseMakeupViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.makeup_list_item, viewGroup, false);
        return new FirebaseMakeupViewHolder(view);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(makeups, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        setIndexInFirebase();
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        makeups.remove(position);
        getRef(position).removeValue();
        Toast.makeText(mContext, "Deleted", Toast.LENGTH_SHORT).show();
    }

    private void setIndexInFirebase(){
        for (Makeup makeup:makeups){
            int index = makeups.indexOf(makeup);
            DatabaseReference ref = getRef(index);
            makeup.setIndex(Integer.toString(index));
            ref.setValue(makeup);
        }
    }

    @Override
    public void stopListening() {
        super.stopListening();
        mRef.removeEventListener(mChildEventListener);
    }
}
