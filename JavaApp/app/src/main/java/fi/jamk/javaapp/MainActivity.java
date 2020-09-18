package fi.jamk.javaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    // Button, ImageButton and AdView
    Button b1;
    private AdView mAdView;
    ImageButton b3;
    private Notification mNotification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotification = new Notification(this);

        // Banner ad

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Explicit intent which opens the next activity by clicking the button

        b1 = (Button) findViewById(R.id.firstButton);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent launchSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(launchSecondActivity);
            }
        });

        final String title = "Hi!";
        final String text = "This is a text notification!";

        // Notification Image Button

        b3 = (ImageButton) findViewById(R.id.notifButton);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder nb = mNotification.
                        getAndroidChannelNotification(title, text);
                mNotification.getManager().notify(101, nb.build());
            }
        });
    }
}

