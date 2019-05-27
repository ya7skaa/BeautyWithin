package com.example.beautywithin.models;

public class Makeup {
    private String mName;
    private String mProductType;
    private String mProductCategory;
    private String mBrand;
    private String mDescription;
    private String mPrice;
    private String mImageUrl;


    public Makeup(String mName, String mProductType, String mProductCategory, String mBrand, String mDescription, String mPrice, String mImageUrl) {
        this.mName = mName;
        this.mProductType = mProductType;
        this.mProductCategory = mProductCategory;
        this.mBrand = mBrand;
        this.mDescription = mDescription;
        this.mPrice = mPrice;
        this.mImageUrl = mImageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmProductType() {
        return mProductType;
    }

    public void setmProductType(String mProductType) {
        this.mProductType = mProductType;
    }

    public String getmProductCategory() {
        return mProductCategory;
    }

    public void setmProductCategory(String mProductCategory) {
        this.mProductCategory = mProductCategory;
    }

    public String getmBrand() {
        return mBrand;
    }

    public void setmBrand(String mBrand) {
        this.mBrand = mBrand;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
