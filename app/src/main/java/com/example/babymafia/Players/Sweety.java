package com.example.babymafia.Players;

public class Sweety extends Player{
    public void visit(Player a) {
        a.setPermission_to_act(false);
    }
}
