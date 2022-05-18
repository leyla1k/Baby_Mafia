package com.example.babymafia.Players;

public class Commissioner extends Player {


    public void check(Player a) {
        if (Permission_to_act == true) {
            a.getRole();
        }
    }

}
