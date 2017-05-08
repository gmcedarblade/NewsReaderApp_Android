package edu.cvtc.android.newsreaderapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * Created by Greg on 5/8/2017.
 */

public class ItemActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        // get references to widgets
        TextView titleTextView = (TextView) findViewById(R.id.titleTextView);
        TextView pubDateTextView = (TextView) findViewById(R.id.pubDateTextView);
        TextView descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        TextView linkTextView = (TextView) findViewById(R.id.linkTextView);

        // get the intent
        Intent intent = getIntent();

        // get the data from the intent
        String pubDate = intent.getStringExtra("pubdate");
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description").replace('\n', ' ');

        // display data on the widgets
        pubDateTextView.setText(pubDate);
        titleTextView.setText(title);
        descriptionTextView.setText(description);

        // set listener
        linkTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        // get intent
        Intent intent = getIntent();

        // get Uri for the link
        String link = intent.getStringExtra("link");
        Uri viewUri = Uri.parse(link);

        // create intent and start it
        Intent viewIntent = new Intent(Intent.ACTION_VIEW, viewUri);
        startActivity(viewIntent);

    }

}
