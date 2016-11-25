package com.mittereflores.origami;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
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


public class Plane_5_Activity extends Activity {

    private ImageView imageView;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane_5);

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
        LinearLayout layout = (LinearLayout)findViewById(R.id.actPlane_5);

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
        t.setScreenName("Plane_5");
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAdvertisingIdCollection(true);


        imageView = (ImageView)findViewById(R.id.vectorImage);
        Drawable drawable = MrVector.inflate(getResources(), R.drawable.paperplane_4_a);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView.setBackground(drawable);
        } else {
            imageView.setBackgroundDrawable(drawable);
        }

        imageView1 = (ImageView)findViewById(R.id.vectorImage1);
        Drawable drawable1 = MrVector.inflate(getResources(), R.drawable.paperplane_4_b);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView1.setBackground(drawable1);
        } else {
            imageView1.setBackgroundDrawable(drawable1);
        }

        imageView2 = (ImageView)findViewById(R.id.vectorImage2);
        Drawable drawable2 = MrVector.inflate(getResources(), R.drawable.paperplane_4_c);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView2.setBackground(drawable2);
        } else {
            imageView2.setBackgroundDrawable(drawable2);
        }

        imageView3 = (ImageView)findViewById(R.id.vectorImage3);
        Drawable drawable3 = MrVector.inflate(getResources(), R.drawable.paperplane_4_d);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView3.setBackground(drawable3);
        } else {
            imageView3.setBackgroundDrawable(drawable3);
        }

        imageView4 = (ImageView)findViewById(R.id.vectorImage4);
        Drawable drawable4 = MrVector.inflate(getResources(), R.drawable.paperplane_4_e);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView4.setBackground(drawable4);
        } else {
            imageView4.setBackgroundDrawable(drawable4);
        }

        imageView5 = (ImageView)findViewById(R.id.vectorImage5);
        Drawable drawable5 = MrVector.inflate(getResources(), R.drawable.paperplane_4_f);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView5.setBackground(drawable5);
        } else {
            imageView5.setBackgroundDrawable(drawable5);
        }

        imageView6 = (ImageView)findViewById(R.id.vectorImage6);
        Drawable drawable6 = MrVector.inflate(getResources(), R.drawable.paperplane_4_g);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView6.setBackground(drawable6);
        } else {
            imageView6.setBackgroundDrawable(drawable6);
        }

        imageView7 = (ImageView)findViewById(R.id.vectorImage7);
        Drawable drawable7 = MrVector.inflate(getResources(), R.drawable.paperplane_4);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView7.setBackground(drawable7);
        } else {
            imageView7.setBackgroundDrawable(drawable7);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_plane_5, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
