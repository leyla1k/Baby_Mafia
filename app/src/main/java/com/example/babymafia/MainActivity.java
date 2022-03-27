package com.example.babymafia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_game_button = (Button) findViewById(R.id.start_game);
        start_game_button.setOnClickListener(b -> {
            Intent intent = new Intent(this, Activity_choose_ofline_online.class);
            startActivity(intent);
            setContentView(R.layout.activity_choose_ofline_online);
        });
    }
}