package com.example.beautywithin.models;

public class Makeup {
    private String mProductType;
    private String mProductCategory;
    private String mBrand;
    private String mRating;
    private String mDescription;
    private int mPrice;
    private String mImageUrl;



    public Makeup(String mProductType, String mProductCategory, String mBrand,String mRating,String mDescription, int mPrice,String mImageUrl) {
        this.mProductType = mProductType;
        this.mProductCategory = mProductCategory;
        this.mBrand = mBrand;
        this.mRating = mRating;
        this.mDescription = mDescription;
        this.mPrice = mPrice;
        this.mImageUrl = mImageUrl;

    }

    public String getmProductType() {
        return mProductType;
    }

    public String getmProductCategory() {
        return mProductCategory;
    }

    public String getmBrand() {
        return mBrand;
    }

    public String getmRating() {
        return mRating;
    }

    public String getmDescription() {
        return mDescription;
    }

    public int getmPrice() {
        return mPrice;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }
}
