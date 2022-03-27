package com.example.babymafia;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_game_button = (Button) findViewById(R.id.start_game);
        set_on_click_listener(start_game_button, ActivityChooseOfflineOnline.class, R.layout.activity_choose_offline_online);

        Button settings_button = (Button) findViewById(R.id.settings);
        set_on_click_listener(settings_button, ActivitySettings.class, R.layout.activity_settings);

        Button how_to_play_button = (Button) findViewById(R.id.how_to_play);
        set_on_click_listener(how_to_play_button, ActivityHowToPlay.class, R.layout.activity_how_to_play);

        Button help_button = (Button) findViewById(R.id.help);
        set_on_click_listener(settings_button, ActivitySettings.class, R.layout.activity_help);

    }

    void set_on_click_listener(Button button, Class activity, int act) {
        button.setOnClickListener(b -> {
            Intent intent = new Intent(this, activity);
            startActivity(intent);
            setContentView(act);
        });
    }
}