package org.humanitypreservationfoundation.pulse.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scheduleSplashScreen();
    }

    private void scheduleSplashScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                routeToMainActivity();
            }
        }, 2000);
    }
    private void routeToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
