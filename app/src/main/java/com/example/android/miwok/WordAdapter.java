package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter( Activity context, ArrayList<Word> objects, int colorResourceId) {
        super(context, 0, objects);
        mColorResourceId = colorResourceId;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {


        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        Word currentWord = getItem(position);


        TextView nameTextView = (TextView) listItemView.findViewById(R.id.trans);
        nameTextView.setText(currentWord.getmMiwokTranslation());


        TextView numberTextView = (TextView) listItemView.findViewById(R.id.eng);
        numberTextView.setText(currentWord.getmDefaultTranslation());


        ImageView imageid = listItemView.findViewById(R.id.image);


        if (currentWord.hasImage()){
            imageid.setImageResource(currentWord.getmImageResourceId());
            imageid.setVisibility(View.VISIBLE);
        }else{
            imageid.setVisibility(View.GONE);
        }


        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
