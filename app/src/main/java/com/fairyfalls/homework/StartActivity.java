package com.fairyfalls.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;

import java.sql.Time;


public class StartActivity extends AppCompatActivity {

    private int time = 0;
    private final int maxTime = 5;
    static final String START_TIME = "time";
    private MyCountDownTimer timer =null;
    final StartActivity thisActivity = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.start_activity);
        setContentView(R.layout.start_activity);
        if ( savedInstanceState != null){
            time = savedInstanceState.getInt(START_TIME);
            timer = new MyCountDownTimer((maxTime-time)*1000,1000);
        }else{
            timer = new MyCountDownTimer(maxTime*1000,1000);
        }


    }
    @Override
    protected void onStart(){
        super.onStart();
        timer.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        timer.cancel();
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(START_TIME, time);

        if( timer != null ) {

            timer.cancel();

        }

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getInt(START_TIME, time);
    }

    private class MyCountDownTimer extends CountDownTimer {

        private MyCountDownTimer(long millis, long countDownInterval) {
            super(millis, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            time++;
        }

        @Override
        public void onFinish() {
            time = 0;
            Intent intent = new Intent(thisActivity, CounterActivity.class);
            startActivity(intent);
            thisActivity.finish();
        }
    }

}
