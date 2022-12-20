package com.example.android.miwok;

import android.view.View;
import android.widget.Toast;

public class NumberClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "open the list number", Toast.LENGTH_SHORT).show();
    }
}
