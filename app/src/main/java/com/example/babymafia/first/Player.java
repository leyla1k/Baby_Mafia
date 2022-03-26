package com.example.babymafia.first;

public class Player {
    String Name="Unnamed";
    boolean Life = true;
    int Role=0;     //1-mafia,2-doctor etc..
    boolean Permission_to_act=false; // if player can kill/cure 1 else 0
    boolean Ability_to_chat=true; //if life=0  everything become 0
    boolean Ability_to_vote=false;




    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
    // we should to write and read name

    public void vote() {
        System.out.println("Мяу!");
    }

}
