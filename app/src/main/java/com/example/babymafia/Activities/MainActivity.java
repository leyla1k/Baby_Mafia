package com.example.babymafia.Activities;

import android.app.Notification;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.babymafia.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void set_on_click_listener(@NonNull Button button, Class activity, int act) {
        button.setOnClickListener(b -> {
            Intent intent = new Intent(this, activity);
            startActivity(intent);
            setContentView(act);
        });
    }
}