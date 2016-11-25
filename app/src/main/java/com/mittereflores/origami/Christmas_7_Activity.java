package com.mittereflores.origami;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.telly.mrvector.MrVector;

public class Christmas_7_Activity extends Activity {

    private ImageView imageView;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christmas_7);

        if (Build.VERSION.SDK_INT >= 21) {

            Slide slide = new Slide();
            slide.setDuration(500);
            getWindow().setEnterTransition(slide);
            getWindow().setReturnTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_a));
        }

        // Создание экземпляра adView.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setVisibility(View.GONE);

        // Поиск разметки LinearLayout (предполагается, что ей был присвоен
        // атрибут android:id="@+id/mainLayout").
        LinearLayout layout = (LinearLayout)findViewById(R.id.christmas_7);

        // Добавление в разметку экземпляра adView.
        layout.addView(adView);

        // Инициирование общего запроса.
        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice("9F6FEC69B4D6EB41F13C9F0058F06AC7") // Asus Fonepad HD 7
//                .addTestDevice("0999F05675AD0BEFAE585E82F3F576CA") // HTC HD 2
                .build();

        // Загрузка adView с объявлением.
        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                adView.setVisibility(View.VISIBLE);
            }
        });

        Tracker t = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
        t.setScreenName("Christmas_santa");
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAdvertisingIdCollection(true);


        imageView = (ImageView) findViewById(R.id.vectorImage);
        Drawable drawable = MrVector.inflate(getResources(), R.drawable.christmas_santa_a);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView.setBackground(drawable);
        } else {
            imageView.setBackgroundDrawable(drawable);
        }

        imageView1 = (ImageView) findViewById(R.id.vectorImage1);
        Drawable drawable1 = MrVector.inflate(getResources(), R.drawable.christmas_santa_b);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView1.setBackground(drawable1);
        } else {
            imageView1.setBackgroundDrawable(drawable1);
        }

        imageView2 = (ImageView) findViewById(R.id.vectorImage2);
        Drawable drawable2 = MrVector.inflate(getResources(), R.drawable.christmas_santa_c);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView2.setBackground(drawable2);
        } else {
            imageView2.setBackgroundDrawable(drawable2);
        }

        imageView3 = (ImageView) findViewById(R.id.vectorImage3);
        Drawable drawable3 = MrVector.inflate(getResources(), R.drawable.christmas_santa_d);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView3.setBackground(drawable3);
        } else {
            imageView3.setBackgroundDrawable(drawable3);
        }

        imageView4 = (ImageView) findViewById(R.id.vectorImage4);
        Drawable drawable4 = MrVector.inflate(getResources(), R.drawable.christmas_santa_e);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView4.setBackground(drawable4);
        } else {
            imageView4.setBackgroundDrawable(drawable4);
        }

        imageView5 = (ImageView) findViewById(R.id.vectorImage5);
        Drawable drawable5 = MrVector.inflate(getResources(), R.drawable.christmas_santa_f);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView5.setBackground(drawable5);
        } else {
            imageView5.setBackgroundDrawable(drawable5);
        }

    }

}
