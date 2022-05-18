package com.example.babymafia.Players;

public class Madman extends Player{

    public void kill(Player a) {
        if (Permission_to_act == true) {
            a.setLife(1);
        }
    }

}
