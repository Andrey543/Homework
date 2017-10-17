package com.fairyfalls.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;



public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
    }
    protected void onResume(){
        super.onResume();

        new CountDownTimer(2000, 1){
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {

                    Intent intent = new Intent(StartActivity.this, CounterActivity.class);
                    startActivity(intent);
            }

        }.start();
    }

}
