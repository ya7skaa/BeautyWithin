package com.example.beautywithin;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MakeupArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mmakeups;
    private String[] mbrands;

    public MakeupArrayAdapter(Context mContext, int resource, String[] mmakeups, String[] mbrands) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mmakeups = mmakeups;
        this.mbrands = mbrands;

    }

        @Override
        public Object getItem(int position) {
            String makeups = mmakeups[position];
            String brands = mbrands[position];
            return String.format("%s \nBRand: %s", makeups, brands);
        }

        @Override
        public int getCount() {
            return mmakeups.length;
    }

}
