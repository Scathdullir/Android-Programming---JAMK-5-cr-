package fi.jamk.javaapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;

public class Notification extends ContextWrapper {

    private NotificationManager mManager;
    public static final String CHANNEL_ID = "CHANNEL ID ";
    public static final String CHANNEL_NAME = "CHANNEL NAME";


    public Notification(Context base) {
        super(base);
        createChannel();
    }

    public void createChannel() {

        // Creating Android Channel
        NotificationChannel androidChannel = new NotificationChannel(CHANNEL_ID,
                CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        // Some settings:
        androidChannel.enableLights(true);
        androidChannel.enableVibration(true);
        androidChannel.setLightColor(Color.BLUE);

        getManager().createNotificationChannel(androidChannel);
    }

    NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    public NotificationCompat.Builder getAndroidChannelNotification(String title, String text) {
        return new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(android.R.drawable.stat_notify_more)
                .setAutoCancel(true);
    }

}