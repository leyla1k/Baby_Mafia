package com.example.babymafia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityChooseOfflineOnline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_offline_online);

        Button offline_game_button = (Button) findViewById(R.id.offline);
        set_on_click_listener(offline_game_button, ActivityOfflineGame.class, R.layout.activity_offline_game);

        Button online_game_button = (Button) findViewById(R.id.online);
        set_on_click_listener(offline_game_button, ActivityOnlineGame.class, R.layout.activity_offline_game);
    }

    void set_on_click_listener(Button button, Class activity, int act) {
        button.setOnClickListener(b -> {
            Intent intent = new Intent(this, activity);
            startActivity(intent);
            setContentView(act);
        });
    }
}