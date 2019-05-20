package com.example.beautywithin.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.beautywithin.R;
import com.example.beautywithin.models.Makeup;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MakeupListAdapter extends RecyclerView.Adapter<MakeupListAdapter.MakeupViewHolder> {
    private ArrayList<Makeup> mmakeups = new ArrayList<>();
    private Context mContext;


    public MakeupListAdapter(Context context, ArrayList<Makeup> restaurants) {
        mContext = context;
        mmakeups = restaurants;
    }

    @Override
    public MakeupListAdapter.MakeupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.makeup_list_item, parent, false);
        MakeupViewHolder viewHolder = new MakeupViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MakeupListAdapter.MakeupViewHolder holder, int position) {
        holder.bindMakeup(mmakeups.get(position));
    }

    @Override
    public int getItemCount() {
        return mmakeups.size();
    }



        public class MakeupViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.makeupImageView) ImageView mMakeupImageView;
            @BindView(R.id.makeupNameTextView) TextView mNameTextView;
            @BindView(R.id.categoryTextView) TextView mCategoryTextView;
            @BindView(R.id.priceTextView) TextView mPriceTextView;
            @BindView(R.id.ratingTextView) TextView mRatingTextView;

            private Context mContext;

            public MakeupViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                mContext = itemView.getContext();
            }

            public void bindMakeup(Makeup makeup) {
                Picasso.get().load(makeup.getmImageUrl()).into(mMakeupImageView);
                mNameTextView.setText(makeup. getmName());
                mCategoryTextView.setText(makeup.getmProductType());
                mPriceTextView.setText(makeup.getmPrice());
                mRatingTextView.setText("Rating: " + makeup.getmRating() + "/5");
            }
    }
}
