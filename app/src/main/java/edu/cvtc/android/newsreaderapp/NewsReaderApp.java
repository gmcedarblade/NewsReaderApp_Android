package edu.cvtc.android.newsreaderapp;

import android.app.Application;
import android.util.Log;

/**
 * Created by Greg on 5/8/2017.
 */

public class NewsReaderApp extends Application {

    private long feedMillis = -1;

    public void setFeedMillis(long feedMillis) { this.feedMillis = feedMillis; }

    public long getFeedMillis() { return feedMillis; }

    @Override
    public void onCreate() {

        super.onCreate();
        Log.d("News reader", "App started");

    }

}
