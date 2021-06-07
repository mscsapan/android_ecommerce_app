package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.test.payment.bKashPayment;

public class LoadingScreen extends AppCompatActivity {
    private ProgressBar loadingProgress;
    int loadingTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_loading_screen);
        loadingProgress = findViewById(R.id.loading_progressbar);
        Thread thread = new Thread(loadingRun);
        thread.start();

    }

    Runnable loadingRun = new Runnable() {
        @Override
        public void run() {
            for (loadingTime = 300; loadingTime <= 1000; loadingTime = loadingTime + 300) {
                try {
                    Thread.sleep(1000);
                    loadingProgress.setProgress(loadingTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            startActivity(new Intent(LoadingScreen.this, bKashPayment.class));
        }
    };
}