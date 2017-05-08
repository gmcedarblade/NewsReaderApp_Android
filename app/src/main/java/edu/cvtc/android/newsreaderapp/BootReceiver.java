package edu.cvtc.android.newsreaderapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Greg on 5/8/2017.
 */

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("News reader", "Boot completed");

        // start service
        Intent service = new Intent(context, NewsReaderService.class);
        context.startService(service);

    }
}
