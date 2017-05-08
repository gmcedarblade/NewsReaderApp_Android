package edu.cvtc.android.newsreaderapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Greg on 5/8/2017.
 */

public class BatteryLowReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("News reader", "Battery low!");

        // stop service
        Intent service = new Intent(context, NewsReaderService.class);
        context.stopService(service);

    }

}
