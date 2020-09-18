package fi.jamk.adsexercise;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    private RewardedAd rewardedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

    }

    public void loadAd(View view) {
        this.rewardedAd = new RewardedAd (this, "ca-app-pub-3940256099942544/5224354917");
        RewardedAdLoadCallback callback = new RewardedAdLoadCallback(){

            @Override
            public void onRewardedAdFailedToLoad (int i) {
                super.onRewardedAdFailedToLoad(i);
                Log.i (TAG, "RewardedAdFailedToLoad");
            }

            @Override
            public void onRewardedAdLoaded () {
                super.onRewardedAdLoaded();
                Log.i (TAG, "onRewardedAdLoaded");
            }

        };
        this.rewardedAd.loadAd(new AdRequest.Builder().build(), callback);
    }

    public void showAd(View view) {
        if (this.rewardedAd.isLoaded()) {

            RewardedAdCallback callback = new RewardedAdCallback() {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem){
                    Log.i(TAG, "onUserEarnedReward");
                }

            };
            this.rewardedAd.show(this, callback);

        }else {
            Log.i(TAG,"Ad not loaded");
        }

    }

}
