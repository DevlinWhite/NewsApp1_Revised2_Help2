package com.example.android.newsapp1_revised;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class NewsAdapter extends ArrayAdapter<News> {

    public static final String LOG_TAG = NewsAdapter.class.getSimpleName();

    public NewsAdapter(@NonNull Context context, @NonNull List<News> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        News currentstory = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }

        TextView newsTextView = convertView.findViewById(R.id.section);
        newsTextView.setText(currentstory.getSection());

        TextView newsAuthorTextView = convertView.findViewById(R.id.author);
        String author = currentstory.getAuthor();

        if (author != null) {
            newsAuthorTextView.setText(author);
        } else {
            newsAuthorTextView.setVisibility(View.GONE);
        }

        TextView newsTitleTextView = convertView.findViewById(R.id.title);
        newsTitleTextView.setText(currentstory.getTitle());

        Date dateObject = new Date(String.valueOf(currentstory.getDate()));


        TextView dateView = (TextView) convertView.findViewById(R.id.publishedDate);

        String formattedDate = formatDate(dateObject);

        dateView.setText(formattedDate);

        return convertView;
    }


    /**
     * Return the formatted date string (i.e. "June 1, 2018") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

}

