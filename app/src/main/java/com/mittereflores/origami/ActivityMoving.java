package com.mittereflores.origami;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.os.Bundle;
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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.telly.mrvector.MrVector;


public class ActivityMoving extends Activity implements View.OnClickListener, ViewTreeObserver.OnScrollChangedListener{

    private ImageView imageView;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
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
        setContentView(R.layout.activity_moving);
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
        LinearLayout layout = (LinearLayout)findViewById(R.id.actMoving);

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
        t.setScreenName("Moving");
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAdvertisingIdCollection(true);

        imageView = (ImageView)findViewById(R.id.vectorImage);
        imageView1 = (ImageView)findViewById(R.id.vectorImage1);
        imageView2 = (ImageView)findViewById(R.id.vectorImage2);
        imageView3 = (ImageView)findViewById(R.id.vectorImage3);
        imageView4 = (ImageView)findViewById(R.id.vectorImage4);
        imageView5 = (ImageView)findViewById(R.id.vectorImage5);

        imageView.setOnClickListener(this);
        Drawable drawable = MrVector.inflate(getResources(), R.drawable.wiggling_dinasor_first_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView.setBackground(drawable);
        } else {
            imageView.setBackgroundDrawable(drawable);
        }


        imageView1.setOnClickListener(this);
        Drawable drawable1 = MrVector.inflate(getResources(), R.drawable.jumpingfrog_first_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView1.setBackground(drawable1);
        } else {
            imageView1.setBackgroundDrawable(drawable1);
        }


        imageView2.setOnClickListener(this);
        Drawable drawable2 = MrVector.inflate(getResources(), R.drawable.croakingfrog_first_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView2.setBackground(drawable2);
        } else {
            imageView2.setBackgroundDrawable(drawable2);
        }


        imageView3.setOnClickListener(this);
        Drawable drawable3 = MrVector.inflate(getResources(), R.drawable.crowofh_h_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView3.setBackground(drawable3);
        } else {
            imageView3.setBackgroundDrawable(drawable3);
        }


        imageView4.setOnClickListener(this);
        Drawable drawable4 = MrVector.inflate(getResources(), R.drawable.flapping2_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView4.setBackground(drawable4);
        } else {
            imageView4.setBackgroundDrawable(drawable4);
        }


        imageView5.setOnClickListener(this);
        Drawable drawable5 = MrVector.inflate(getResources(), R.drawable.pakupaku_title);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView5.setBackground(drawable5);
        } else {
            imageView5.setBackgroundDrawable(drawable5);
        }

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        GoogleAnalytics.getInstance(ActivityMoving.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        GoogleAnalytics.getInstance(ActivityMoving.this).reportActivityStop(this);
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
        getMenuInflater().inflate(R.menu.menu_activity_moving, menu);
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
                startActivity(new Intent(this,Moving_1_Activity.class), compat.toBundle());
                Tracker a = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                a.send(new HitBuilders.EventBuilder()
                        .setCategory("Moving")
                        .setAction("Wiggling_dinasor")
                        .build());
                break;
            case R.id.vectorImage1:
                ActivityOptionsCompat compat1 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Moving_2_Activity.class), compat1.toBundle());
                Tracker b = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                b.send(new HitBuilders.EventBuilder()
                        .setCategory("Moving")
                        .setAction("Jumpingfrog")
                        .build());
                break;
            case R.id.vectorImage2:
                ActivityOptionsCompat compat2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Moving_3_Activity.class), compat2.toBundle());
                Tracker c = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                c.send(new HitBuilders.EventBuilder()
                        .setCategory("Moving")
                        .setAction("Croakingfrog")
                        .build());
                break;
            case R.id.vectorImage3:
                ActivityOptionsCompat compat3 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Moving_4_Activity.class), compat3.toBundle());
                Tracker d = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                d.send(new HitBuilders.EventBuilder()
                        .setCategory("Moving")
                        .setAction("Crowofh")
                        .build());
                break;
            case R.id.vectorImage4:
                ActivityOptionsCompat compat4 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Moving_5_Activity.class), compat4.toBundle());
                Tracker e = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                e.send(new HitBuilders.EventBuilder()
                        .setCategory("Moving")
                        .setAction("Flapping2")
                        .build());
                break;
            case R.id.vectorImage5:
                ActivityOptionsCompat compat5 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
                startActivity(new Intent(this,Moving_6_Activity.class), compat5.toBundle());
                Tracker f = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                f.send(new HitBuilders.EventBuilder()
                        .setCategory("Moving")
                        .setAction("Pakupaku")
                        .build());
                break;
        }
    }
}
