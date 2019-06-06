package com.example.beautywithin.adapters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.beautywithin.R;

import com.example.beautywithin.models.Makeup;
import com.squareup.picasso.Picasso;



import org.parceler.Parcels;


import butterknife.BindView;
import butterknife.ButterKnife;

 public class MakeupDetailFragment extends Fragment {
     @BindView(R.id.makeupImageView) ImageView mImageLabel;
     @BindView(R.id.makeupNameTextView) TextView mNameLabel;
     @BindView(R.id.categoryTextView) TextView mProductCategoryLabel;
     @BindView(R.id.ratingTextView) TextView mRatingLabel;
     @BindView(R.id.brandTextView) TextView mbrandLabel;
     @BindView(R.id.descriptionTextView) TextView mDescriptionLabel;
     @BindView(R.id.linkTextView) TextView mWebsiteLinkLabel;
     @BindView(R.id.saveMakeupButton) TextView mSaveMakeupButton;

     private Makeup mMakeup;


    public static MakeupDetailFragment newInstance (Makeup makeup){
        MakeupDetailFragment makeupDetailFragment = new MakeupDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("makeup", Parcels.wrap(makeup));
        makeupDetailFragment.setArguments(args);
        return makeupDetailFragment;
    }

     @Override
     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         mMakeup = Parcels.unwrap(getArguments().getParcelable("makeup"));
     }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_makeup_detail, container, false);
        ButterKnife.bind(this, view);


        Picasso.get().load(mMakeup.getmImageUrl()).into(mImageLabel);

        mNameLabel.setText(mMakeup.getmName());
        mProductCategoryLabel.setText( mMakeup.getmProductCategory());

        mbrandLabel.setText(mMakeup.getmBrand());
        mWebsiteLinkLabel.setText( mMakeup.getmWebsiteLink());
        mDescriptionLabel.setText( mMakeup.getmDescription());


        return view;
    }

}
