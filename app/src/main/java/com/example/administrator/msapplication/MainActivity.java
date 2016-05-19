package com.example.administrator.msapplication;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import tyrantgit.widget.HeartLayout;

/**
 *
 */
public class MainActivity extends Activity implements View.OnClickListener,View.OnLongClickListener{

    private Random mRandom = new Random();
    private Timer mTimer = new Timer();
    private HeartLayout mHeartLayout;
    private RelativeLayout pager;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeartLayout = (HeartLayout) findViewById(R.id.heart_layout);
        pager=(RelativeLayout)findViewById(R.id.pager);
        pager.setOnClickListener(this);
        pager.setOnLongClickListener(this);



    }

    private void longHeart() {
        mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mHeartLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        mHeartLayout.addHeart(randomColor());
                    }
                });
            }
        }, 500, 200);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
    }

    private int randomColor() {
        return Color.rgb(mRandom.nextInt(255), mRandom.nextInt(255), mRandom.nextInt(255));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pager:
                mHeartLayout.addHeart(randomColor());
                break;
        }
    }


    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.pager:
                for(int i=0;i<50;i++){

                mHeartLayout.addHeart(randomColor());
                }
                break;
        }

        return false;
    }
}
