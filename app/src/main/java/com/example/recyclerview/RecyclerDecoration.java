package com.example.recyclerview;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerDecoration extends RecyclerView.ItemDecoration {
    private final int divHeight;

    public RecyclerDecoration(int divHeight) {
        this.divHeight = divHeight;
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = divHeight;
    }
}