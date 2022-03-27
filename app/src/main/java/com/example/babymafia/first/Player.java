package com.example.babymafia.first;

public class Player {
    public String Name="Unnamed";
    protected boolean Life = true;
    protected int Role=0;     //1-mafia,2-doctor etc..
    protected boolean Permission_to_act=false; // if player can kill/cure 1 else 0
    protected boolean Ability_to_chat=true; //if life=0  everything become 0
    protected boolean Ability_to_vote=false;




    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }


    public void setRole(int role) {
        Role = role;
    }

    public int getRole() {//need to know who is he
        return Role;
    }

    public void setPermission_to_act(boolean permission_to_act) {
        Permission_to_act = permission_to_act;
    }

    public void getPermission_to_act(boolean permission_to_act) {
        Permission_to_act = permission_to_act;
    }

    public void setLife(boolean life) {
        Life = life;
    }


}
