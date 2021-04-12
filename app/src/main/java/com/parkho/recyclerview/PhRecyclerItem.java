package com.parkho.recyclerview;

public class PhRecyclerItem {

    private int imageResId;

    private String strName;

    public PhRecyclerItem(int a_resId, String a_strName) {
        imageResId = a_resId;
        strName = a_strName;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return strName;
    }
}