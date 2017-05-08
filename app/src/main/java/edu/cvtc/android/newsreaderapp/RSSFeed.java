package edu.cvtc.android.newsreaderapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Greg on 5/8/2017.
 */

public class RSSFeed {

    public final static String ACTION_UPDATE_AVAILABLE = "edu.cvtc.android.newsreaderapp.ACTION_UPDATE_AVAILABLE";

    private String title = null;
    private String pubDate = null;
    private ArrayList<RSSItem> items;

    private SimpleDateFormat dateInFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");

    public RSSFeed() { items = new ArrayList<RSSItem>(); }

    public void setTitle(String title) { this.title = title; }

    public String getTitle() { return title; }

    public void setPubDate(String pubDate) { this.pubDate = pubDate; }

    public  String getPubDate() { return pubDate; }

    public int addItem(RSSItem item) {

        items.add(item);
        return items.size();

    }

}
