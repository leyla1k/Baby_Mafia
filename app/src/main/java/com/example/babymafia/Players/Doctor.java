package com.example.babymafia.Players;

public class Doctor extends Player{

    public void cure(Player a) {
        if ((Permission_to_act == true)&&(a.getLife()==1)) {
            a.setLife(2);
        }
    }


}
