package com.bohaifisher.broadreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class OuterBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "This is an outer broadcast receiver.", Toast.LENGTH_SHORT).show();
    }
}
