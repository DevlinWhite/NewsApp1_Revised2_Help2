package com.example.android.newsapp1_revised;

import java.util.Date;

public class News {

    private final String mTitle;
    private final String mAuthor;
    private final String mSection;
    private final Date mDate;
    private final String mUrl;

    public News(String title, String author, String section, Date date, String url) {
        mTitle = title;
        mAuthor = author;
        mSection = section;
        mDate = date;
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getSection() {
        return mSection;
    }

    public Date getDate() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
