package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrador on 06/04/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    /*Class constructor*/
    public WordAdapter(@NonNull Context context,@NonNull ArrayList<Word> objects, int colorResourceId) {
        super(context, 0, objects);
        mColorResourceId = colorResourceId;
    }

    /*Class methods*/
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView miwokTextView = (TextView) view.findViewById(R.id.miwok_text_view);
        TextView defaultTextView = (TextView) view.findViewById(R.id.default_text_view);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        LinearLayout textLayout = (LinearLayout) view.findViewById(R.id.text_layout);

        Word currentWord = getItem(position);

        miwokTextView.setText(currentWord.getMiwokTranslation());
        defaultTextView.setText(currentWord.getDefaultTranslation());
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textLayout.setBackgroundColor(color);

        return view;
    }
}
