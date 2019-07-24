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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(@NonNull Context context, ArrayList<Word> wordArrayList, int colorResourceId) {
        super(context, 0, wordArrayList);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        Word currentWord = getItem(position);
        View textContainer = listItemView.findViewById(R.id.background_linear_layout);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else
            imageView.setVisibility(View.GONE);
        TextView textView = (TextView) listItemView.findViewById(R.id.default_text_view);
        textView.setText(currentWord.getMiwokTranslation());
        textView = (TextView) listItemView.findViewById(R.id.english_text_view);
        textView.setText(currentWord.getDefaultTranslation());
        return listItemView;
    }
}
