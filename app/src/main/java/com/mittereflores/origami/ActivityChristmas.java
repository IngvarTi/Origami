package com.mittereflores.origami;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.android.gms.ads.*;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.telly.mrvector.MrVector;

public class ActivityChristmas extends Activity implements View.OnClickListener, ViewTreeObserver.OnScrollChangedListener{

    private ImageView imageView;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;
    private ScrollView scrollView;
    private float mActionBarHeight;
    private ActionBar mActionBar;
    private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            TransitionInflater inflater = TransitionInflater.from(this);
            Transition transition = inflater.inflateTransition(R.transition.transition_a);
            getWindow().setExitTransition(transition);

            Slide slide = new Slide();
            slide.setDuration(500);
            getWindow().setEnterTransition(slide);
            getWindow().setReturnTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_a));
        }

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_christmas);
        final TypedArray styledAttributes = getTheme().obtainStyledAttributes(
                new int[] { android.R.attr.actionBarSize });
        mActionBarHeight = styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        mActionBar = getActionBar();
        ((ScrollView)findViewById(R.id.scrollView)).getViewTreeObserver().addOnScrollChangedListener(this);
        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03A9F4")));

        scrollView = (ScrollView)findViewById(R.id.scrollView);
        Drawable drawable0 = MrVector.inflate(getResources(), R.drawable.backgrsquaredawhite);
        if (Build.VERSION.SDK_INT >= 16) {
            scrollView.setBackground(drawable0);
        } else {
            scrollView.setBackgroundDrawable(drawable0);
        }

        // Создание экземпляра adView.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setVisibility(View.GONE);

        // Поиск разметки LinearLayout (предполагается, что ей был присвоен
        // атрибут android:id="@+id/mainLayout").
        LinearLayout layout = (LinearLayout)findViewById(R.id.actChristmas);

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
        t.setScreenName("Christmas");
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAdvertisingIdCollection(true);

        imageView = (ImageView)findViewById(R.id.vectorImage);
        imageView1 = (ImageView)findViewById(R.id.vectorImage1);
        imageView2 = (ImageView)findViewById(R.id.vectorImage2);
        imageView3 = (ImageView)findViewById(R.id.vectorImage3);
        imageView4 = (ImageView)findViewById(R.id.vectorImage4);
        imageView5 = (ImageView)findViewById(R.id.vectorImage5);
        imageView6 = (ImageView)findViewById(R.id.vectorImage6);
        imageView7 = (ImageView)findViewById(R.id.vectorImage7);
        imageView8 = (ImageView)findViewById(R.id.vectorImage8);
        imageView9 = (ImageView)findViewById(R.id.vectorImage9);

        imageView.setOnClickListener(this);
        Drawable drawable = MrVector.inflate(getResources(), R.drawable.snow_crystal_e_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView.setBackground(drawable);
        } else {
            imageView.setBackgroundDrawable(drawable);
        }


        imageView1.setOnClickListener(this);
        Drawable drawable1 = MrVector.inflate(getResources(), R.drawable.snow_crystal_1_e_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView1.setBackground(drawable1);
        } else {
            imageView1.setBackgroundDrawable(drawable1);
        }


        imageView2.setOnClickListener(this);
        Drawable drawable2 = MrVector.inflate(getResources(), R.drawable.snow_crystal_2_e_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView2.setBackground(drawable2);
        } else {
            imageView2.setBackgroundDrawable(drawable2);
        }


        imageView3.setOnClickListener(this);
        Drawable drawable3 = MrVector.inflate(getResources(), R.drawable.christmas_tree_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView3.setBackground(drawable3);
        } else {
            imageView3.setBackgroundDrawable(drawable3);
        }


        imageView4.setOnClickListener(this);
        Drawable drawable4 = MrVector.inflate(getResources(), R.drawable.christmas_star_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView4.setBackground(drawable4);
        } else {
            imageView4.setBackgroundDrawable(drawable4);
        }


        imageView5.setOnClickListener(this);
        Drawable drawable5 = MrVector.inflate(getResources(), R.drawable.christmas_boot_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView5.setBackground(drawable5);
        } else {
            imageView5.setBackgroundDrawable(drawable5);
        }


        imageView6.setOnClickListener(this);
        Drawable drawable6 = MrVector.inflate(getResources(), R.drawable.christmas_santa_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView6.setBackground(drawable6);
        } else {
            imageView6.setBackgroundDrawable(drawable6);
        }


        imageView7.setOnClickListener(this);
        Drawable drawable7 = MrVector.inflate(getResources(), R.drawable.christmas_stick_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView7.setBackground(drawable7);
        } else {
            imageView7.setBackgroundDrawable(drawable7);
        }


        imageView8.setOnClickListener(this);
        Drawable drawable8 = MrVector.inflate(getResources(), R.drawable.christmas_present_box_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView8.setBackground(drawable8);
        } else {
            imageView8.setBackgroundDrawable(drawable8);
        }

        imageView9.setOnClickListener(this);
        Drawable drawable9 = MrVector.inflate(getResources(), R.drawable.christmas_snowman_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView9.setBackground(drawable9);
        } else {
            imageView9.setBackgroundDrawable(drawable9);
        }


    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        GoogleAnalytics.getInstance(ActivityChristmas.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        GoogleAnalytics.getInstance(ActivityChristmas.this).reportActivityStop(this);
    }


    @Override
    public void onPause() {
        adView.pause();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        adView.resume();
    }

    @Override
    public void onDestroy() {
        adView.destroy();
        super.onDestroy();
    }

    @Override
    public void onScrollChanged() {
        float y = ((ScrollView)findViewById(R.id.scrollView)).getScrollY();
        if (y >= mActionBarHeight && mActionBar.isShowing()) {
            mActionBar.hide();
        } else if ( y==0 && !mActionBar.isShowing()) {
            mActionBar.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_christmas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {

            case R.id.action_settings:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.rateuri)));
                startActivity(intent);
                break;
        }


//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.vectorImage:
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this, Christmas_1_crystal_Activity.class), compat.toBundle());
                Tracker a = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                a.send(new HitBuilders.EventBuilder()
                        .setCategory("Christmas")
                        .setAction("Christmas_1_crystal")
                        .build());
                break;
            case R.id.vectorImage1:
                ActivityOptionsCompat compat1 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Christmas_2_crystal_Activity.class), compat1.toBundle());
                Tracker b = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                b.send(new HitBuilders.EventBuilder()
                        .setCategory("Christmas")
                        .setAction("Christmas_2_crystal")
                        .build());
                break;
            case R.id.vectorImage2:
                ActivityOptionsCompat compat2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Christmas_3_crystal_Activity.class), compat2.toBundle());
                Tracker c = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                c.send(new HitBuilders.EventBuilder()
                        .setCategory("Christmas")
                        .setAction("Christmas_3_crystal")
                        .build());
                break;
            case R.id.vectorImage3:
                ActivityOptionsCompat compat3 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Christmas_4_Activity.class), compat3.toBundle());
                Tracker d = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                d.send(new HitBuilders.EventBuilder()
                        .setCategory("Christmas")
                        .setAction("Christmas_tree")
                        .build());
                break;
            case R.id.vectorImage4:
                ActivityOptionsCompat compat4 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Christmas_5_Activity.class), compat4.toBundle());
                Tracker e = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                e.send(new HitBuilders.EventBuilder()
                        .setCategory("Christmas")
                        .setAction("Christmas_star")
                        .build());
                break;
            case R.id.vectorImage5:
                ActivityOptionsCompat compat5 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Christmas_6_Activity.class), compat5.toBundle());
                Tracker f = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                f.send(new HitBuilders.EventBuilder()
                        .setCategory("Christmas")
                        .setAction("Christmas_boot")
                        .build());
                break;
            case R.id.vectorImage6:
                ActivityOptionsCompat compat6 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Christmas_7_Activity.class), compat6.toBundle());
                Tracker g = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                g.send(new HitBuilders.EventBuilder()
                        .setCategory("Christmas")
                        .setAction("Christmas_santa")
                        .build());
                break;
            case R.id.vectorImage7:
                ActivityOptionsCompat compat7 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Christmas_8_Activity.class), compat7.toBundle());
                Tracker h = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                h.send(new HitBuilders.EventBuilder()
                        .setCategory("Christmas")
                        .setAction("Christmas_stick")
                        .build());
                break;
            case R.id.vectorImage8:
                ActivityOptionsCompat compat8 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Christmas_9_Activity.class), compat8.toBundle());
                Tracker i = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                i.send(new HitBuilders.EventBuilder()
                        .setCategory("Christmas")
                        .setAction("Christmas_present_box")
                        .build());
                break;
            case R.id.vectorImage9:
                ActivityOptionsCompat compat9 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Christmas_10_Activity.class), compat9.toBundle());
                Tracker j = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                j.send(new HitBuilders.EventBuilder()
                        .setCategory("Christmas")
                        .setAction("Christmas_snowman")
                        .build());
                break;
        }
    }
}
