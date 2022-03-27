package com.example.babymafia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ActivityCreateGameOrJoinGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game_or_join_game);

        Button create_game_button = (Button) findViewById(R.id.create_game);
        set_on_click_listener(create_game_button, ActivityCreateGame.class, R.layout.activity_create_game);

        Button join_game_button = (Button) findViewById(R.id.join_game);
        set_on_click_listener(join_game_button, ActivityJoinGame.class, R.layout.activity_join_game);

    }

    void set_on_click_listener(Button button, Class activity, int act) {
        button.setOnClickListener(b -> {
            Intent intent = new Intent(this, activity);
            startActivity(intent);
            setContentView(act);
        });
    }
}