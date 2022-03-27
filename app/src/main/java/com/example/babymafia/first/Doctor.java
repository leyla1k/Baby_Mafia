package com.example.babymafia.first;

public class Doctor extends Player{

    public void kill(Player a) {
        if (Permission_to_act == true) {
            a.setLife(true);
        }
    }


}
